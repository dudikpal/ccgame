package hobby.ccgame.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hobby.ccgame.command.CreateCardCommand;
import hobby.ccgame.command.FilterCardsCommand;
import hobby.ccgame.command.UpdateCardCommand;
import hobby.ccgame.dto.CardDTO;
import hobby.ccgame.entity.Card;
import hobby.ccgame.mapper.DTOMapper;
import hobby.ccgame.repository.CCGameRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CCGameService {

    private CCGameRepository ccGameRepository;

    private ModelMapper modelMapper;

    private ObjectMapper objectMapper;


    public List <CardDTO> getAllCards() {

        List <CardDTO> result;

        result = ccGameRepository.findAll()
            .stream()
            .map(card -> DTOMapper.CardToCardDTO(card))
            .collect(Collectors.toList());

        return result;
    }


    public CardDTO createCard(CreateCardCommand command) {

        Card card = new Card();

        if (ccGameRepository.findById(command.getId()).isEmpty()) {

            card = modelMapper.map(command, Card.class);
            ccGameRepository.save(card);
        }

        return DTOMapper.CardToCardDTO(card);
    }

    @Transactional
    public CardDTO updateCard(UpdateCardCommand command) {

        Card card = ccGameRepository.findById(command.getId())
            .orElseThrow(() -> new IllegalArgumentException("Cannot fond card with this id: " + command.getId()));

        modelMapper.map(command, card);

        ccGameRepository.save(card);

        return DTOMapper.CardToCardDTO(card);
    }


    public void removeCard(String id) {

        Card card = ccGameRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Cannot find card with id: " + id));

        ccGameRepository.delete(card);
    }

    
    public List <CardDTO> uploadCardsFromFile(String cardsJson) {

        String cards;
        ObjectMapper mapper = new ObjectMapper();
        List <CardDTO> cardDTOs = new ArrayList <>();

        try {

            List <Card> cardList = mapper.readValue(cardsJson, new TypeReference <List <Card>>() {
            });

            for (Card card : cardList) {

                if (ccGameRepository.findById(card.getId()).isEmpty()) {

                    CreateCardCommand createCardCommand = modelMapper.map(card, CreateCardCommand.class);
                    cardDTOs.add(createCard(createCardCommand));
                } else {

                    UpdateCardCommand updateCardCommand = modelMapper.map(card, UpdateCardCommand.class);
                    cardDTOs.add(updateCard(updateCardCommand));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cardDTOs;
    }


    public List <CardDTO> findCards(String command) {

        if (!command.isEmpty()) {

            Card card = null;
            List <String> checkedFieldNames = new ArrayList <>();
            String checks;
            JsonNode json;
            JsonNode betweens = null;

            try {

                json = objectMapper.readTree(command);
                checks = json.get("checks").toPrettyString();
                betweens = objectMapper.readTree(json.get("betweens").toPrettyString());
                card = objectMapper.readValue(json.get("card").toPrettyString(), Card.class);
                extractCheckedFieldNames(checkedFieldNames, checks);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            List <Card> exampledCards = getExampledCards(card);
            List <Card> checkedCards = getCheckedCards(checkedFieldNames, exampledCards);

            List <Card> afterBetweens = getCardsAfterBetweens(betweens, checkedCards);

            List <CardDTO> filteredCards = getFilteredCards(afterBetweens);

            return filteredCards;
        }

        return getAllCards();
    }


    private List <CardDTO> getFilteredCards(List <Card> afterBetweens) {

        List <CardDTO> filteredCards = new ArrayList <>();

        for (Card c : afterBetweens) {

            filteredCards.add(DTOMapper.CardToCardDTO(c));
        }

        return filteredCards;
    }


    private List <Card> getCheckedCards(List <String> checkedFieldNames, List <Card> exampledCards) {

        List <Card> checkedCards = extractCheckedCards(checkedFieldNames, exampledCards);

        if (checkedCards.size() == 0) {

            return exampledCards;
        }

        return checkedCards;
    }


    private List <Card> extractCheckedCards(List <String> checkedFieldNames, List <Card> exampledCards) {

        List <Card> checkedCards = new ArrayList <>();

        for (Card c : exampledCards) {

            Map cardMap = objectMapper.convertValue(c, Map.class);

            if (isNullFieldCount(checkedFieldNames, cardMap) == checkedFieldNames.size()) {

                checkedCards.add(c);
            }
        }

        return checkedCards;
    }


    private int isNullFieldCount(List <String> checkedFieldNames, Map cardMap) {

        int counter = 0;

        for (int i = 0; i < checkedFieldNames.size(); i++) {

            if (cardMap.get(checkedFieldNames.get(i)).equals("N/A")
                || cardMap.get(checkedFieldNames.get(i)).toString().matches("-\\d+(\\.\\d+)?")) {

                counter++;
            }
        }

        return counter;
    }


    private List <Card> getCardsAfterBetweens(JsonNode betweens, List <Card> checkedCards) {

        List <Card> afterBetweens = new ArrayList <>();

        for (Card c : checkedCards) {

            Map cardMap = objectMapper.convertValue(c, Map.class);
            int counter = 0;

            for (int i = 0; i < betweens.size(); i++) {

                String attrName = betweens.get(i).get("name").asText();

                if (betweens.get(i).get("values").get(0).toString().contains(".")) {

                    double firstParam = betweens.get(i).get("values").get(0).asDouble();
                    double secondParam = betweens.get(i).get("values").get(1).asDouble();

                    counter += getAsDouble(cardMap, attrName, firstParam, secondParam);

                } else {

                    int firstParam = betweens.get(i).get("values").get(0).asInt();
                    int secondParam = betweens.get(i).get("values").get(1).asInt();

                    counter += getAsInt(cardMap, attrName, firstParam, secondParam);
                }
            }

            if (counter == betweens.size()) {

                afterBetweens.add(c);
            }
        }

        return afterBetweens;
    }


    private int getAsInt(Map cardMap, String attrName, int firstParam, int secondParam) {

        if ((int) cardMap.get(attrName) >= firstParam
            && (int) cardMap.get(attrName) <= secondParam) {

            return 1;
        }

        return 0;
    }


    private int getAsDouble(Map cardMap, String attrName, double firstParam, double secondParam) {

        if ((double) cardMap.get(attrName) >= firstParam
            && (double) cardMap.get(attrName) <= secondParam) {

            return 1;
        }

        return 0;
    }


    private List <Card> getExampledCards(Card card) {

        ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase();
        Example <Card> example = Example.of(card, matcher);
        List <Card> cards = ccGameRepository.findAll(example);

        return cards;
    }


    private void extractCheckedFieldNames(List <String> checkedFieldNames, String checks) {

        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(checks);

        while (m.find()) {

            checkedFieldNames.add(m.group());
        }
    }


    public void removeAllCard() {

        ccGameRepository.deleteAll();
    }
}

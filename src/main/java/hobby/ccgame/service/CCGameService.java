package hobby.ccgame.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import hobby.ccgame.command.CreateCardCommand;
import hobby.ccgame.command.RemoveCardCommand;
import hobby.ccgame.command.UpdateCardCommand;
import hobby.ccgame.dto.CardDTO;
import hobby.ccgame.entity.Card;
import hobby.ccgame.mapper.DTOMapper;
import hobby.ccgame.repository.CCGameRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import org.bson.json.JsonObject;
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
        ObjectMapper objectMapper = new ObjectMapper();



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

        Card card = ccGameRepository.findById(command.getId()).orElseThrow(() -> new IllegalArgumentException("Cannot fond card with this id: " + command.getId()));

        modelMapper.map(command, card);

        ccGameRepository.save(card);

        return DTOMapper.CardToCardDTO(card);
    }


    public void removeCard(String id) {

        Card card = ccGameRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Cannot find card with id: " + id));

        ccGameRepository.delete(card);
    }

    public List <CardDTO> uploadCardsFromFile(String fileName) {

        Path path = Path.of("src/main/resources/" + fileName);
        String cards;
        ObjectMapper mapper = new ObjectMapper();
        List <CardDTO> cardDTOs = new ArrayList <>();

        try {

            cards = Files.readString(path);
            List <CreateCardCommand> cardList = mapper.readValue(cards, new TypeReference <List <CreateCardCommand>>() {
            });

            for (CreateCardCommand card : cardList) {
                //System.out.println(card);
                cardDTOs.add(createCard(card));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cardDTOs;
    }


    public Object findCards(String params) {

        if (!params.isEmpty()) {

            ObjectMapper objectMapper = new ObjectMapper();
            List <String> checkedFieldNames = new ArrayList <>();
            List <CardDTO> result = new ArrayList <>();
            String checks = null;
            JsonNode json = null;
            JsonNode betweens = null;
            Card card = null;

            try {
                json = objectMapper.readTree(params);
                //System.out.println(json.toPrettyString());
                checks = json.get("checks").toPrettyString();
                //System.out.println(json.get("betweens").toPrettyString());
                betweens = objectMapper.readTree(json.get("betweens").toPrettyString());

                extractCheckedFieldNames(checkedFieldNames, checks);

                card = objectMapper.readValue(json.get("card").toPrettyString(), Card.class);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase();
            Example <Card> example = Example.of(card, matcher);
            List <Card> cards = ccGameRepository.findAll(example);
            List <Card> checkedCards = new ArrayList <>();
            int checkedFieldCount = checkedFieldNames.size();

            for (Card c : cards) {

                Map cardMap = objectMapper.convertValue(c, Map.class);
                int counter = 0;

                for (int i = 0; i < checkedFieldCount; i++) {

                    if (cardMap.get(checkedFieldNames.get(i)).equals("N/A")
                        || cardMap.get(checkedFieldNames.get(i)).toString().matches("-\\d+(\\.\\d+)?")) {

                        counter++;
                    }
                }

                if (counter == checkedFieldCount) {

                    checkedCards.add(c);
                }
            }

            if (checkedCards.size() == 0) {
                checkedCards = cards;
            }

            List<Card> afterBetweens = new ArrayList <>();

            for (Card c : checkedCards) {

                Map cardMap = objectMapper.convertValue(c, Map.class);
                int counter = 0;

                for (int i = 0; i < betweens.size(); i++) {

                    String attrName = betweens.get(i).get("name").asText();

                    if (betweens.get(i).get("values").get(0).toString().contains(".")) {

                        double firstParam = betweens.get(i).get("values").get(0).asDouble();
                        double secondParam = betweens.get(i).get("values").get(1).asDouble();

                        if ((double)cardMap.get(attrName) >= firstParam
                            && (double)cardMap.get(attrName) <= secondParam) {

                            counter++;
                        }

                    } else {

                        int firstParam = betweens.get(i).get("values").get(0).asInt();
                        int secondParam = betweens.get(i).get("values").get(1).asInt();

                        if ((int)cardMap.get(attrName) >= firstParam
                            && (int)cardMap.get(attrName) <= secondParam) {

                            counter++;
                        }
                    }

                }

                if (counter == betweens.size()) {

                    afterBetweens.add(c);
                }
            }

            for (Card c : afterBetweens) {

                result.add(DTOMapper.CardToCardDTO(c));
            }

            return result;
        }

        return getAllCards();
    }


    private void extractCheckedFieldNames(List<String> checkedFieldNames, String checks) {

        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(checks);

        while (m.find()) {

            checkedFieldNames.add(m.group());
        }
    }
}

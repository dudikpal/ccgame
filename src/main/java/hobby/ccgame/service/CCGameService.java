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
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CCGameService {

    private CCGameRepository ccGameRepository;

    private ModelMapper modelMapper;


    public List <CardDTO> getCards(Optional <String> jsonData) {

        List <CardDTO> result;
        ObjectMapper objectMapper = new ObjectMapper();


        if (jsonData.isPresent()) {

            JsonNode json = null;
            Card card = null;

            try {
                json = objectMapper.readTree(jsonData.get());
                card = objectMapper.readValue(jsonData.get(), Card.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


            ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("manufacturer", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

            log.debug(String.valueOf(jsonData.get()));
            Example <Card> example = Example.of(card, matcher);
            System.out.println("example = " + example);

            // innen mÉg nem jön ki a volvo
            /*result = ccGameRepository.findAll(example)
                .stream()
                .map(findedCard -> modelMapper.map(findedCard, CardDTO.class))
                .collect(Collectors.toList());*/

            List <Card> cards = ccGameRepository.findAll(example);
            result = new ArrayList <>();

            for (Card c : cards) {
                result.add(DTOMapper.CardToCardDTO(c));
            }

            return result;
        } else {
            result = ccGameRepository.findAll()
                .stream()
                .map(card -> DTOMapper.CardToCardDTO(card))
                .collect(Collectors.toList());
        }

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


    public void removeCard(RemoveCardCommand command) {

        Card card = ccGameRepository.findById(command.getId())
            .orElseThrow(() -> new IllegalArgumentException("Cannot find card with id: " + command.getId()));

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

        List <CardDTO> result;
        ObjectMapper objectMapper = new ObjectMapper();


        if (!params.isEmpty()) {

            JsonNode json = null;
            Card card = null;

            try {
                json = objectMapper.readTree(params);
                card = objectMapper.readValue(params, Card.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


            ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("manufacturer", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

            System.out.println("params: " + params);
            System.out.println("json: " + json);
            System.out.println("card: " + card);
            Example <Card> example = Example.of(card, matcher);
            System.out.println("example = " + example);

            // innen mÉg nem jön ki a volvo
            /*result = ccGameRepository.findAll(example)
                .stream()
                .map(findedCard -> modelMapper.map(findedCard, CardDTO.class))
                .collect(Collectors.toList());*/

            List <Card> cards = ccGameRepository.findAll(example);
            result = new ArrayList <>();

            for (Card c : cards) {
                result.add(DTOMapper.CardToCardDTO(c));
            }
            System.out.println("result: " + result);

            return result;
        }
        return getCards(Optional.empty());
    }
}

package hobby.ccgame.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import hobby.ccgame.command.CreateCardCommand;
import hobby.ccgame.command.UpdateCardCommand;
import hobby.ccgame.dto.CardDTO;
import hobby.ccgame.dto.FindCardsParamsDTO;
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
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
//@Slf4j
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

        if (ccGameRepository.existsById(command.getId())) {

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

        /*Ez j9ön
        {
    "card":{
        "id":null,
        "manufacturer":"au",
        "type":null,
        "year":null,
        "country":null,
        "doors":null,
        "body":null,
        "seats":null,
        "driveWheel":null,
        "fuelType":null,
        "fuelTankCapacity":null,
        "engineCapacity":null,
        "powerKW":null,
        "powerHP":null,
        "maxTorque":null,
        "topSpeed":null,
        "acceleration":null,
        "weight":null,
        "length":null,
        "width":null,
        "height":null,
        "groundClearance":null,
        "abs":null,
        "tractionControl":null,
        "imageUrl":null,
        "logoURL":null,
        "carPageUrl":null,
        "objectPositionHorizontal":null,
        "objectPositionVertical":null,
        "objectWidth":null,
        "objectHeight":null,
        "gear1st":null,
        "gear2nd":null,
        "gear3rd":null,
        "gear4th":null,
        "gear5th":null,
        "gear6th":null,
        "finalDrive":null
    },
    "checks":[

    ],
    "betweens":[

    ],
    "multipleValues":[

    ]
}
        */
        FindCardsParamsDTO findParams = stringToParams(command);

        if (!findParamsIsEmpty(findParams)) {


            JsonNode simpleValues = findParams.getSimpleValues();
            List <String> checkedFieldNames = findParams.getCheckedFieldNames();
            JsonNode betweens = findParams.getBetweens();
            JsonNode multipleValues = findParams.getMultipleValues();


            //List <Card> exampledCards = getExampledCards(card);
            List <Card> simpleValuesCards = getSimpleValues(simpleValues);
            List <Card> checkedCards = getCheckedCards(checkedFieldNames, simpleValuesCards);
            List <Card> afterBetweens = getCardsAfterBetweens(betweens, checkedCards);
            List <Card> afterMoreOptions = getCardsAfterMoreOptions(multipleValues, afterBetweens);
            List <CardDTO> filteredCards = afterMoreOptions.stream()
                .map(item -> DTOMapper.CardToCardDTO(item))
                .collect(Collectors.toList());

            /*System.out.println(command);
            List <CardDTO> filteredCards = findCardsRepository.findCards("Audi")
            .stream()
            .map(filteredCard -> DTOMapper.CardToCardDTO(filteredCard))
            .collect(Collectors.toList());
            System.out.println(filteredCards);*/

            System.out.println("innerempty");
            return filteredCards;
        }

        /*QCard qCard = new QCard("c1");
        Predicate predicate = qCard.manufacturer.like("a");
        List<CardDTO> sss = StreamSupport.stream(findCardsRepository.findAll(predicate).spliterator(), false)
            .map(c -> DTOMapper.CardToCardDTO(c))
            .collect(Collectors.toList());

        System.out.println(command);
        System.out.println(qCard);
        System.out.println(predicate);
        System.out.println(sss);
        return sss;*/

        //System.out.println(cardDao.findCardsByAllParams());
        return getAllCards();
    }


    private boolean findParamsIsEmpty(FindCardsParamsDTO params) {

        return params.getCheckedFieldNames().size() == 0
            && params.getBetweens().size() == 0
            && params.getMultipleValues().size() == 0
            && params.getSimpleValues().size() == 0;
    }


    private FindCardsParamsDTO stringToParams(String command) {

        String checks = "";
        JsonNode json = null;
        JsonNode simpleValues = null;
        List <String> checkedFieldNames = null;
        JsonNode betweens = null;
        JsonNode multipleValues = null;
        FindCardsParamsDTO result = new FindCardsParamsDTO();

        try {


            json = objectMapper.readTree(command);
            checks = json.get("checks").toPrettyString();
            betweens = objectMapper.readTree(json.get("betweens").toPrettyString());
            multipleValues = objectMapper.readTree(json.get("multipleValues").toPrettyString());
            simpleValues = objectMapper.readTree(json.get("simpleValues").toPrettyString());
            checkedFieldNames = extractCheckedFieldNames(checks);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        result.setChecks(checks);
        result.setBetweens(betweens);
        result.setMultipleValues(multipleValues);
        result.setSimpleValues(simpleValues);
        result.setCheckedFieldNames(checkedFieldNames);

        return result;
    }


    private List <Card> getSimpleValues(JsonNode simpleValues) {

        List <Card> allCards = getAllCards().stream()
            .map(c -> DTOMapper.CardDTOToCard(c))
            .collect(Collectors.toList());

        if (simpleValues.size() == 0) {

            return allCards;
        }

        Set <Card> afterSimpleValues = new HashSet <>();

        for (int i = 0; i < simpleValues.size(); i++) {

            String attrName = simpleValues.get(0).get("name").asText();

            for (JsonNode option : simpleValues.get(0).get("values")) {

                for (Card c : allCards) {

                    Map cardMap = objectMapper.convertValue(c, Map.class);

                    if (cardMap.get(attrName).toString().trim().toLowerCase().contains(option.asText().trim().toLowerCase())) {

                        afterSimpleValues.add(c);
                        continue;
                    }
                }
            }
        }

        return afterSimpleValues.stream()
            .collect(Collectors.toList());

    }


    private List <Card> getCardsAfterMoreOptions(JsonNode moreOptions, List <Card> afterBetweens) {

        if (moreOptions.size() == 0) {

            return afterBetweens;
        }

        Set <Card> afterMoreOptions = new HashSet <>();

        for (int i = 0; i < moreOptions.size(); i++) {

            String attrName = moreOptions.get(0).get("name").asText();

            for (JsonNode option : moreOptions.get(0).get("values")) {

                for (Card c : afterBetweens) {

                    Map cardMap = objectMapper.convertValue(c, Map.class);

                    if (cardMap.get(attrName).toString().trim().toLowerCase().contains(option.asText().trim().toLowerCase())) {

                        afterMoreOptions.add(c);
                        continue;
                    }
                }
            }
        }

        return afterMoreOptions.stream()
            .collect(Collectors.toList());
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


    private List <String> extractCheckedFieldNames(String checks) {

        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(checks);
        List <String> checkedFields = new ArrayList <>();

        while (m.find()) {

            checkedFields.add(m.group());
        }

        return checkedFields;
    }


    public void removeAllCard() {

        ccGameRepository.deleteAll();
    }


    private List <Card> sortByAlphabetAsc(List <Card> cards) {

        return cards.stream()
            .sorted()
            .collect(Collectors.toList());
    }
}

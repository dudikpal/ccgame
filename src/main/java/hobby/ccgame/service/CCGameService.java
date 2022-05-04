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

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    private MongoTemplate mongoTemplate;


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

        FindCardsParamsDTO findParams = stringToParams(command);

        if (!findParamsIsEmpty(findParams)) {

            System.out.println("innerParams");
            JsonNode simpleValues = findParams.getSimpleValues();
            List <String> checkedFieldNames = findParams.getCheckedFieldNames();
            JsonNode betweens = findParams.getBetweens();
            JsonNode multipleValues = findParams.getMultipleValues();

            Query query = new Query();
            List <CardDTO> filteredCards = new ArrayList <>();
            List <Criteria> criterias = new ArrayList <>();

            criterias.addAll(simpleCriterias(simpleValues));
            criterias.addAll(isNullCriterias(checkedFieldNames));
            criterias.addAll(multipleCriterias(multipleValues));
            criterias.addAll(betweensCriterias(betweens));

            query.addCriteria(new Criteria().orOperator(criterias.toArray(new Criteria[criterias.size()])));

            filteredCards.addAll(Arrays.stream(mongoTemplate.find(query, Card.class).toArray())
                .map(c -> DTOMapper.CardToCardDTO((Card) c))
                .collect(Collectors.toList()));

            return filteredCards;
        }

        return getAllCards();
    }


    private List <Criteria> betweensCriterias(JsonNode betweensValues) {

        List <Criteria> criterias = new ArrayList <>();

        for (JsonNode node : betweensValues) {
            String attrName = node.get("name").asText();

            try {
                String valueFrom = objectMapper.readTree(node.get("values").toPrettyString()).get(0).asText().trim();
                String valueTo = objectMapper.readTree(node.get("values").toPrettyString()).get(1).asText().trim();
                Number parsedFrom;
                Number parsedTo;

                if (valueFrom.contains(".") || valueTo.contains(".")) {

                    parsedFrom = Double.parseDouble(valueFrom);
                    parsedTo = Double.parseDouble(valueTo);
                } else {

                    parsedFrom = Integer.parseInt(valueFrom);
                    parsedTo = Integer.parseInt(valueTo);
                }

                criterias.add(Criteria.where(attrName).gte(parsedFrom).lte(parsedTo));

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return criterias;
    }


    private List <Criteria> multipleCriterias(JsonNode multipleValues) {

        List <Criteria> criterias = new ArrayList <>();

        for (JsonNode node : multipleValues) {
            String attrName = node.get("name").asText();

            try {
                for (JsonNode value : objectMapper.readTree(node.get("values").toPrettyString())) {

                    criterias.add(createCriteriaWithParsedValue(attrName, value.asText().trim()));
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return criterias;
    }


    private List <Criteria> isNullCriterias(List <String> fieldNames) {

        List <Criteria> criterias = new ArrayList <>();

        for (String fieldName : fieldNames) {

            criterias.add(new Criteria().orOperator(
                Criteria.where(fieldName).regex("N/A"),
                Criteria.where(fieldName).lt(0)
            ));
        }

        return criterias;
    }


    private List <Criteria> simpleCriterias(JsonNode simpleValues) {

        List <Criteria> criterias = new ArrayList <>();

        for (JsonNode node : simpleValues) {
            String attrName = node.get("name").asText();

            try {
                String value = objectMapper.readTree(node.get("values").toPrettyString()).get(0).asText().trim();

                criterias.add(createCriteriaWithParsedValue(attrName, value));

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return criterias;
    }


    private Criteria createCriteriaWithParsedValue(String attrName, String value) {

        String regex = "";

        if (value.chars().allMatch(Character::isDigit) || value.contains(".")) {

            Number parsedValue;

            if (value.contains(".")) {
                parsedValue = Double.parseDouble(value);
            } else {
                parsedValue = Integer.parseInt(value);
            }

            return Criteria.where(attrName).is(parsedValue);

        } else {

            regex = "(?i).*" + value + ".*";
            return Criteria.where(attrName).regex(regex);
        }
    }


    private boolean findParamsIsEmpty(FindCardsParamsDTO params) {

        return params.getCheckedFieldNames().size() == 0
            && params.getBetweens().size() == 0
            && params.getMultipleValues().size() == 0
            && params.getSimpleValues().size() == 0;
    }


    private FindCardsParamsDTO stringToParams(String command) {

        String checks = "";
        JsonNode json;
        JsonNode betweens = null;
        JsonNode simpleValues = null;
        JsonNode multipleValues = null;
        List <String> checkedFieldNames = null;
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
}

package hobby.ccgame.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hobby.ccgame.command.CreateCardCommand;
import hobby.ccgame.command.RemoveCardCommand;
import hobby.ccgame.command.UpdateCardCommand;
import hobby.ccgame.dto.CardDTO;
import hobby.ccgame.entity.Card;
import hobby.ccgame.mapper.DTOMapper;
import hobby.ccgame.repository.CCGameRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CCGameService {

    private CCGameRepository ccGameRepository;

    private ModelMapper modelMapper;


    public List <CardDTO> getAllCards() {

        return ccGameRepository.findAll()
            .stream()
            .map(card -> DTOMapper.CardToCardDTO(card))
            .collect(Collectors.toList());
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

    public List<CardDTO> uploadCardsFromFile(String fileName) {

        Path path = Path.of("src/main/resources/" + fileName);
        String cards;
        ObjectMapper mapper = new ObjectMapper();
        List<CardDTO> cardDTOs = new ArrayList <>();

        try {

            cards = Files.readString(path);
            List<CreateCardCommand> cardList = mapper.readValue(cards, new TypeReference <List<CreateCardCommand>>(){});

            for (CreateCardCommand card : cardList) {
                //System.out.println(card);
                cardDTOs.add(createCard(card));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cardDTOs;
    }
}

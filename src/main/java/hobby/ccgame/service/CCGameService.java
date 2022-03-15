package hobby.ccgame.service;

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

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CCGameService {

    private CCGameRepository ccGameRepository;

    private ModelMapper modelMapper;

    //private ICardMapper cardMapper;


    public List <CardDTO> getAllCards() {

        return ccGameRepository.findAll()
            .stream()
            .map(card -> DTOMapper.CardToCardDTO(card))
            .collect(Collectors.toList());
    }


    public CardDTO createCard(CreateCardCommand command) {

        Card card = modelMapper.map(command, Card.class);

        ccGameRepository.save(card);

        return DTOMapper.CardToCardDTO(card);
    }

    @Transactional
    public CardDTO updateCard(String id, UpdateCardCommand command) {

        Card card = ccGameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot fond card with this id: " + id));

        modelMapper.map(command, card);

        ccGameRepository.save(card);

        return DTOMapper.CardToCardDTO(card);
    }


    public void removeCard(RemoveCardCommand command) {

        Card card = ccGameRepository.findById(command.getId())
            .orElseThrow(() -> new IllegalArgumentException("Cannot find card with id: " + command.getId()));

        ccGameRepository.delete(card);
    }
}

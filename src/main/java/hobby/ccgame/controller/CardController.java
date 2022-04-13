package hobby.ccgame.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hobby.ccgame.command.CreateCardCommand;
import hobby.ccgame.command.FilterCardsCommand;
import hobby.ccgame.command.UpdateCardCommand;
import hobby.ccgame.dto.CardDTO;
import hobby.ccgame.service.CCGameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cards")
@AllArgsConstructor
public class CardController {

    private CCGameService ccGameService;

    private ObjectMapper objectMapper;


    @GetMapping
    public List<CardDTO> getAllCards() {

        return ccGameService.getAllCards();
    }


    @PostMapping
    public CardDTO createCard(@RequestBody CreateCardCommand command) {

        return ccGameService.createCard(command);
    }


    @PutMapping
    public CardDTO updateCard(@RequestBody UpdateCardCommand command) {

        return ccGameService.updateCard(command);
    }


    @DeleteMapping("/{id}")
    public void removeCard(@PathVariable String id) {

        ccGameService.removeCard(id);
    }


    @PostMapping("/uploadfile/{filename}")
    public List <CardDTO> uploadCardsFromFile(@PathVariable String filename) {

        return ccGameService.uploadCardsFromFile(filename);
    }


    @PostMapping("/find")
    public List<CardDTO> findCards(@RequestBody String command) {

        return ccGameService.findCards(command);
    }
}

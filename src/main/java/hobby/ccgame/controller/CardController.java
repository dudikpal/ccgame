package hobby.ccgame.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import hobby.ccgame.command.CreateCardCommand;
import hobby.ccgame.command.RemoveCardCommand;
import hobby.ccgame.command.UpdateCardCommand;
import hobby.ccgame.dto.CardDTO;
import hobby.ccgame.service.CCGameService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cards")
@AllArgsConstructor
public class CardController {

    private CCGameService ccGameService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllCards() {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String sol = mapper.writeValueAsString(ccGameService.getAllCards());
            return sol;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String createCard(@RequestBody CreateCardCommand command) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            return mapper.writeValueAsString(ccGameService.createCard(command));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
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


    @PostMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findCards(@RequestBody String params) {

        // tesztre
        ObjectMapper mapper = new ObjectMapper();
        //params = "{\"manufacturer\":\"volvo\"}";

        try {

            String sol = mapper.writeValueAsString(ccGameService.findCards(params));
            System.out.println(sol);
            return sol;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
        // tesztre
    }
}

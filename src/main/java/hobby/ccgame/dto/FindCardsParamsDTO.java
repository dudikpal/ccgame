package hobby.ccgame.dto;

import com.fasterxml.jackson.databind.JsonNode;
import hobby.ccgame.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindCardsParamsDTO {

    private Card card;

    private String checks;

    private JsonNode betweens;

    private JsonNode multipleValues;

    private List <String> checkedFieldNames;


}

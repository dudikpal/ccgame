package hobby.ccgame.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindCardsParamsDTO {

    private JsonNode simpleValues;

    private String checks;

    private JsonNode betweens;

    private JsonNode multipleValues;

    private List <String> checkedFieldNames;


}

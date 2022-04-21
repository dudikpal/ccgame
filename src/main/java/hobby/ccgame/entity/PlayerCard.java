package hobby.ccgame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("player_cards")
public class PlayerCard {

    @Id
    private String id;

    private String cardId;

    private Boolean locked;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}

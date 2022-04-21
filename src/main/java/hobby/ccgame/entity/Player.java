package hobby.ccgame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("players")
public class Player {

    private String id;

    private String Name;

    private String email;

    private LocalDate createdAt;

    private LocalDate lastLogin;
}

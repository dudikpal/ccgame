package hobby.ccgame.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCardCommand {

  private String id;

  private String manufacturer;

  private String type;

  private Integer year;

  private Integer doors;

  private String body;

  private Integer seats;

  private String driveWheel;

  private String engineType;

  private String fuelType;

  private Integer engineCapacity;

  private Integer powerKW;

  private Integer powerHP;

  private Integer maxTorque;

  private Integer topSpeed;

  private Double acceleration;

  private Integer weight;

  private Integer length;

  private Integer width;

  private Integer height;

  private Integer groundClearance;

  private String ABS;

  private String tractionControl;

  private String imageUrl;

  private String logoURL;

  private String carPageUrl;

  private String objectPositionHorizontal;

  private String objectPositionVertical;

  private String objectWidth;

  private String objectHeight;

  private Double gear1st;

  private Double gear2nd;

  private Double gear3rd;

  private Double gear4th;

  private Double gear5th;

  private Double gear6th;

  private Double finalDrive;
}

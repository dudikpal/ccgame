package hobby.ccgame.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("cards")
public class Card {

  @Id
  private String id;

  private String manufacturer;

  private String type;

  private Integer year;

  private String country;

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

  private String abs;

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


  /*public Card buildCard() {

    return new Card(id, manufacturer, type, year, doors, body, seats, driveWheel, engineType, fuelType, engineCapacity, powerKW, powerHP, maxTorque, topSpeed, acceleration, weight, length, width, height, groundClearance, ABS, tractionControl, imageUrl, logoURL, carPageUrl, objectPositionHorizontal, objectPositionVertical, objectWidth, objectHeight, gear1st, gear2nd, gear3rd, gear4th, gear5th, gear6th, finalDrive);
  }


  public Card id(String id) {

    this.id = id;
    return this;
  }


  public Card manufacturer(String manufacturer) {

    this.manufacturer = manufacturer;
    return this;
  }


  public Card type(String type) {

    this.type = type;
    return this;
  }

  public Card year(Integer year) {

    this.year = year;
    return this;
  }

  public Card doors(Integer doors) {

    this.doors = doors;
    return this;
  }
  public Card body(String body) {

    this.body = body;
    return this;
  }

  public Card seats(Integer seats) {

    this.seats = seats;
    return this;
  }

  public Card driveWheel(String driveWheel) {

    this.driveWheel = driveWheel;
    return this;
  }

  public Card engineType(String engineType) {

    this.engineType = engineType;
    return this;
  }

  public Card fuelType(String fuelType) {

    this.fuelType = fuelType;
    return this;
  }

  public Card engineCapacity(Integer engineCapacity) {

    this.engineCapacity = engineCapacity;
    return this;
  }

  public Card powerKW(Integer powerKW) {

    this.powerKW = powerKW;
    return this;
  }

  public Card powerHP(Integer powerHP) {

    this.powerHP = powerHP;
    return this;
  }

  public Card maxTorque(Integer maxTorque) {

    this.maxTorque = maxTorque;
    return this;
  }

  public Card topSpeed(Integer topSpeed) {

    this.topSpeed = topSpeed;
    return this;
  }

  public Card acceleration(Double acceleration) {

    this.acceleration = acceleration;
    return this;
  }

  public Card weight(Integer weight) {

    this.weight = weight;
    return this;
  }

  public Card length(Integer length) {

    this.length = length;
    return this;
  }

  public Card width(Integer width) {

    this.width = width;
    return this;
  }

  public Card height(Integer height) {

    this.height = height;
    return this;
  }

  public Card groundClearance(Integer groundClearance) {

    this.groundClearance = groundClearance;
    return this;
  }

  public Card ABS(String ABS) {

    this.ABS = ABS;
    return this;
  }

  public Card tractionControl(String tractionControl) {

    this.tractionControl = tractionControl;
    return this;
  }

  public Card imageUrl(String imageUrl) {

    this.imageUrl = imageUrl;
    return this;
  }

  public Card logoURL(String logoURL) {

    this.logoURL = logoURL;
    return this;
  }

  public Card carPageUrl(String carPageUrl) {

    this.carPageUrl = carPageUrl;
    return this;
  }

  public Card objectPositionHorizontal(String objectPositionHorizontal) {

    this.objectPositionHorizontal = objectPositionHorizontal;
    return this;
  }

  public Card objectPositionVertical(String objectPositionVertical) {

    this.objectPositionVertical = objectPositionVertical;
    return this;
  }

  public Card objectWidth(String objectWidth) {

    this.objectWidth = objectWidth;
    return this;
  }

  public Card objectHeight(String objectHeight) {

    this.objectHeight = objectHeight;
    return this;
  }

  public Card gear1st(Double gear1st) {

    this.gear1st = gear1st;
    return this;
  }

  public Card gear2nd(Double gear2nd) {

    this.gear2nd = gear2nd;
    return this;
  }

  public Card gear3rd(Double gear3rd) {

    this.gear3rd = gear3rd;
    return this;
  }

  public Card gear4th(Double gear4th) {

    this.gear4th = gear4th;
    return this;
  }

  public Card gear5th(Double gear5th) {

    this.gear5th = gear5th;
    return this;
  }

  public Card gear6th(Double gear6th) {

    this.gear6th = gear6th;
    return this;
  }

  public Card finalDrive(Double finalDrive) {

    this.finalDrive = finalDrive;
    return this;
  }*/

}

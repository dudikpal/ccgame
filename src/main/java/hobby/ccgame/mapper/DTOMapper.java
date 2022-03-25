package hobby.ccgame.mapper;

import hobby.ccgame.dto.CardDTO;
import hobby.ccgame.entity.Card;

public final class DTOMapper {

  public static CardDTO CardToCardDTO(Card card) {

    CardDTO cardDTO = new CardDTO();
    cardDTO.setId(card.getId());
    cardDTO.getManufacturer().setValue(card.getManufacturer());
    cardDTO.getType().setValue(card.getType());
    cardDTO.getYear().setValue(card.getYear());
    cardDTO.getCountry().setValue(card.getCountry());
    cardDTO.getDoors().setValue(card.getDoors());
    cardDTO.getBody().setValue(card.getBody());
    cardDTO.getSeats().setValue(card.getSeats());
    cardDTO.getDriveWheel().setValue(card.getDriveWheel());
    cardDTO.getEngineType().setValue(card.getEngineType());
    cardDTO.getFuelType().setValue(card.getFuelType());
    cardDTO.getEngineCapacity().setValue(card.getEngineCapacity());
    cardDTO.getPowerKW().setValue(card.getPowerKW());
    cardDTO.getPowerHP().setValue(card.getPowerHP());
    cardDTO.getMaxTorque().setValue(card.getMaxTorque());
    cardDTO.getTopSpeed().setValue(card.getTopSpeed());
    cardDTO.getAcceleration().setValue(card.getAcceleration());
    cardDTO.getWeight().setValue(card.getWeight());
    cardDTO.getLength().setValue(card.getLength());
    cardDTO.getWidth().setValue(card.getWidth());
    cardDTO.getHeight().setValue(card.getHeight());
    cardDTO.getGroundClearance().setValue(card.getGroundClearance());
    cardDTO.getAbs().setValue(card.getAbs());
    cardDTO.getTractionControl().setValue(card.getTractionControl());
    cardDTO.getImageUrl().setValue(card.getImageUrl());
    cardDTO.getLogoURL().setValue(card.getLogoURL());
    cardDTO.getCarPageUrl().setValue(card.getCarPageUrl());
    cardDTO.getObjectPositionHorizontal().setValue(card.getObjectPositionHorizontal());
    cardDTO.getObjectPositionVertical().setValue(card.getObjectPositionVertical());
    cardDTO.getObjectWidth().setValue(card.getObjectWidth());
    cardDTO.getObjectHeight().setValue(card.getObjectHeight());
    cardDTO.getGear1st().setValue(card.getGear1st());
    cardDTO.getGear2nd().setValue(card.getGear2nd());
    cardDTO.getGear3rd().setValue(card.getGear3rd());
    cardDTO.getGear4th().setValue(card.getGear4th());
    cardDTO.getGear5th().setValue(card.getGear5th());
    cardDTO.getGear6th().setValue(card.getGear6th());
    cardDTO.getFinalDrive().setValue(card.getFinalDrive());

    return cardDTO;
  }
}

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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/cards")
@AllArgsConstructor
public class CardController {

  private CCGameService ccGameService;


  @GetMapping
  public JsonNode getAllCards() {
    // élesre
    /*return ccGameService.getAllCards();*/

    // tesztre
    String json = "[{\"id\":\"2007_audi_a4_71215\",\"manufacturer\":{\"name\":\"Manufacturer\",\"value\":\"Audi\"},\"type\":{\"name\":\"Car type\",\"value\":\"A4 2.0T\"},\"year\":{\"name\":\"Year\",\"value\":2007},\"doors\":{\"name\":\"Doors\",\"value\":4},\"body\":{\"name\":\"Body type\",\"value\":\"Sedan\"},\"seats\":{\"name\":\"Seats\",\"value\":5},\"driveWheel\":{\"name\":\"Drive wheel\",\"value\":\"FWD\"},\"engineType\":{\"name\":\"Engine type\",\"value\":\"Gas\"},\"fuelType\":{\"name\":\"Fuel type\",\"value\":\"N/A\"},\"fuelTankCapacity\":{\"name\":\"Fuel tank capacity\",\"value\":70},\"engineCapacity\":{\"name\":\"Engine capacity (cm<sup>3</sup>)\",\"value\":2000},\"powerKW\":{\"name\":\"Power (KW)\",\"value\":149},\"powerHP\":{\"name\":\"Power (HP)\",\"value\":200},\"maxTorque\":{\"name\":\"Max Torque (Nm)\",\"value\":280},\"topSpeed\":{\"name\":\"Top speed (km/h)\",\"value\":-1},\"acceleration\":{\"name\":\"0-100 (km/h)\",\"value\":7.58},\"weight\":{\"name\":\"Weight (kg)\",\"value\":1544},\"length\":{\"name\":\"Length (mm)\",\"value\":4572},\"width\":{\"name\":\"Width (mm)\",\"value\":1752},\"height\":{\"name\":\"Height (mm)\",\"value\":1422},\"groundClearance\":{\"name\":\"Ground clearence (mm)\",\"value\":101},\"tractionControl\":{\"name\":\"Traction control\",\"value\":\"N/A\"},\"imageUrl\":{\"name\":\"Car image URL\",\"value\":\"https://www.carspecs.us/photos/259364f9e0cb9d7bd9fa122bb9f0ae23f7baf8bb-2000.jpg\"},\"logoURL\":{\"name\":\"Manufacturer Logo URL\",\"value\":\"N/A\"},\"carPageUrl\":{\"name\":\"Car page Url\",\"value\":\"https://www.carspecs.us/cars/2007/audi/a4/71215\"},\"objectPositionHorizontal\":{\"name\":\"Object horizontal position\",\"value\":\"0vh\"},\"objectPositionVertical\":{\"name\":\"Object vertical position\",\"value\":\"0vh\"},\"objectWidth\":{\"name\":\"Object width\",\"value\":\"100%\"},\"objectHeight\":{\"name\":\"Object height\",\"value\":\"100%\"},\"gear1st\":{\"name\":\"1st gear\",\"value\":3.67},\"gear2nd\":{\"name\":\"2nd gear\",\"value\":2.05},\"gear3rd\":{\"name\":\"3rd gear\",\"value\":1.37},\"gear4th\":{\"name\":\"4th gear\",\"value\":1.03},\"gear5th\":{\"name\":\"5th gear\",\"value\":0.8},\"gear6th\":{\"name\":\"6th gear\",\"value\":0.66},\"finalDrive\":{\"name\":\"Final drive\",\"value\":3.75},\"abs\":{\"name\":\"ABS\",\"value\":\"yes\"}},{\"id\":\"2014_dodge_avenger_35821\",\"manufacturer\":{\"name\":\"Manufacturer\",\"value\":\"Dodge\"},\"type\":{\"name\":\"Car type\",\"value\":\"Avenger R/T 3.6L V6 FFV\"},\"year\":{\"name\":\"Year\",\"value\":2014},\"doors\":{\"name\":\"Doors\",\"value\":-1},\"body\":{\"name\":\"Body type\",\"value\":\"Sedan\"},\"seats\":{\"name\":\"Seats\",\"value\":-1},\"driveWheel\":{\"name\":\"Drive wheel\",\"value\":\"FWD\"},\"engineType\":{\"name\":\"Engine type\",\"value\":\"Flex Fuel\"},\"fuelType\":{\"name\":\"Fuel type\",\"value\":\"N/A\"},\"fuelTankCapacity\":{\"name\":\"Fuel tank capacity\",\"value\":63},\"engineCapacity\":{\"name\":\"Engine capacity (cm<sup>3</sup>)\",\"value\":3600},\"powerKW\":{\"name\":\"Power (KW)\",\"value\":211},\"powerHP\":{\"name\":\"Power (HP)\",\"value\":283},\"maxTorque\":{\"name\":\"Max Torque (Nm)\",\"value\":352},\"topSpeed\":{\"name\":\"Top speed (km/h)\",\"value\":-1},\"acceleration\":{\"name\":\"0-100 (km/h)\",\"value\":6.56},\"weight\":{\"name\":\"Weight (kg)\",\"value\":1636},\"length\":{\"name\":\"Length (mm)\",\"value\":4876},\"width\":{\"name\":\"Width (mm)\",\"value\":1828},\"height\":{\"name\":\"Height (mm)\",\"value\":1473},\"groundClearance\":{\"name\":\"Ground clearence (mm)\",\"value\":152},\"tractionControl\":{\"name\":\"Traction control\",\"value\":\"yes\"},\"imageUrl\":{\"name\":\"Car image URL\",\"value\":\"https://www.carspecs.us/photos/1788f258b325d388020a443a59440ad7c82ec6ec-2000.jpg\"},\"logoURL\":{\"name\":\"Manufacturer Logo URL\",\"value\":\"N/A\"},\"carPageUrl\":{\"name\":\"Car page Url\",\"value\":\"https://www.carspecs.us/cars/2014/dodge/avenger/35821\"},\"objectPositionHorizontal\":{\"name\":\"Object horizontal position\",\"value\":\"0vh\"},\"objectPositionVertical\":{\"name\":\"Object vertical position\",\"value\":\"0vh\"},\"objectWidth\":{\"name\":\"Object width\",\"value\":\"100%\"},\"objectHeight\":{\"name\":\"Object height\",\"value\":\"100%\"},\"gear1st\":{\"name\":\"1st gear\",\"value\":-1.0},\"gear2nd\":{\"name\":\"2nd gear\",\"value\":-1.0},\"gear3rd\":{\"name\":\"3rd gear\",\"value\":-1.0},\"gear4th\":{\"name\":\"4th gear\",\"value\":-1.0},\"gear5th\":{\"name\":\"5th gear\",\"value\":-1.0},\"gear6th\":{\"name\":\"6th gear\",\"value\":-1.0},\"finalDrive\":{\"name\":\"Final drive\",\"value\":-1.0},\"abs\":{\"name\":\"ABS\",\"value\":\"yes\"}},{\"id\":\"1991_volvo_940_36963\",\"manufacturer\":{\"name\":\"Manufacturer\",\"value\":\"Volvo\"},\"type\":{\"name\":\"Car type\",\"value\":\"940 SE 2.3L Turbo\"},\"year\":{\"name\":\"Year\",\"value\":1991},\"doors\":{\"name\":\"Doors\",\"value\":-1},\"body\":{\"name\":\"Body type\",\"value\":\"Sedan\"},\"seats\":{\"name\":\"Seats\",\"value\":-1},\"driveWheel\":{\"name\":\"Drive wheel\",\"value\":\"RWD\"},\"engineType\":{\"name\":\"Engine type\",\"value\":\"Gas\"},\"fuelType\":{\"name\":\"Fuel type\",\"value\":\"N/A\"},\"fuelTankCapacity\":{\"name\":\"Fuel tank capacity\",\"value\":79},\"engineCapacity\":{\"name\":\"Engine capacity (cm<sup>3</sup>)\",\"value\":2300},\"powerKW\":{\"name\":\"Power (KW)\",\"value\":120},\"powerHP\":{\"name\":\"Power (HP)\",\"value\":162},\"maxTorque\":{\"name\":\"Max Torque (Nm)\",\"value\":264},\"topSpeed\":{\"name\":\"Top speed (km/h)\",\"value\":-1},\"acceleration\":{\"name\":\"0-100 (km/h)\",\"value\":8.62},\"weight\":{\"name\":\"Weight (kg)\",\"value\":1499},\"length\":{\"name\":\"Length (mm)\",\"value\":4851},\"width\":{\"name\":\"Width (mm)\",\"value\":1752},\"height\":{\"name\":\"Height (mm)\",\"value\":1397},\"groundClearance\":{\"name\":\"Ground clearence (mm)\",\"value\":101},\"tractionControl\":{\"name\":\"Traction control\",\"value\":\"N/A\"},\"imageUrl\":{\"name\":\"Car image URL\",\"value\":\"https://www.carspecs.us/photos/071902b9dff386a2fa002262defabde2064e7b80-2000.jpg\"},\"logoURL\":{\"name\":\"Manufacturer Logo URL\",\"value\":\"N/A\"},\"carPageUrl\":{\"name\":\"Car page Url\",\"value\":\"https://www.carspecs.us/cars/1991/volvo/940/36963\"},\"objectPositionHorizontal\":{\"name\":\"Object horizontal position\",\"value\":\"0vh\"},\"objectPositionVertical\":{\"name\":\"Object vertical position\",\"value\":\"0vh\"},\"objectWidth\":{\"name\":\"Object width\",\"value\":\"100%\"},\"objectHeight\":{\"name\":\"Object height\",\"value\":\"100%\"},\"gear1st\":{\"name\":\"1st gear\",\"value\":-1.0},\"gear2nd\":{\"name\":\"2nd gear\",\"value\":-1.0},\"gear3rd\":{\"name\":\"3rd gear\",\"value\":-1.0},\"gear4th\":{\"name\":\"4th gear\",\"value\":-1.0},\"gear5th\":{\"name\":\"5th gear\",\"value\":-1.0},\"gear6th\":{\"name\":\"6th gear\",\"value\":-1.0},\"finalDrive\":{\"name\":\"Final drive\",\"value\":-1.0},\"abs\":{\"name\":\"ABS\",\"value\":\"N/A\"}},{\"id\":\"1999_oldsmobile_aurora_7802\",\"manufacturer\":{\"name\":\"Manufacturer\",\"value\":\"Oldsmobile\"},\"type\":{\"name\":\"Car type\",\"value\":\"Aurora 4.0L V8\"},\"year\":{\"name\":\"Year\",\"value\":1999},\"doors\":{\"name\":\"Doors\",\"value\":4},\"body\":{\"name\":\"Body type\",\"value\":\"Sedan\"},\"seats\":{\"name\":\"Seats\",\"value\":5},\"driveWheel\":{\"name\":\"Drive wheel\",\"value\":\"FWD\"},\"engineType\":{\"name\":\"Engine type\",\"value\":\"Gas\"},\"fuelType\":{\"name\":\"Fuel type\",\"value\":\"N/A\"},\"fuelTankCapacity\":{\"name\":\"Fuel tank capacity\",\"value\":70},\"engineCapacity\":{\"name\":\"Engine capacity (cm<sup>3</sup>)\",\"value\":4000},\"powerKW\":{\"name\":\"Power (KW)\",\"value\":186},\"powerHP\":{\"name\":\"Power (HP)\",\"value\":250},\"maxTorque\":{\"name\":\"Max Torque (Nm)\",\"value\":352},\"topSpeed\":{\"name\":\"Top speed (km/h)\",\"value\":-1},\"acceleration\":{\"name\":\"0-100 (km/h)\",\"value\":7.63},\"weight\":{\"name\":\"Weight (kg)\",\"value\":1770},\"length\":{\"name\":\"Length (mm)\",\"value\":5207},\"width\":{\"name\":\"Width (mm)\",\"value\":1879},\"height\":{\"name\":\"Height (mm)\",\"value\":1397},\"groundClearance\":{\"name\":\"Ground clearence (mm)\",\"value\":127},\"tractionControl\":{\"name\":\"Traction control\",\"value\":\"N/A\"},\"imageUrl\":{\"name\":\"Car image URL\",\"value\":\"https://www.carspecs.us/photos/15dfb0b05a2431c7711395ddd0273bce0c133742-2000.jpg\"},\"logoURL\":{\"name\":\"Manufacturer Logo URL\",\"value\":\"N/A\"},\"carPageUrl\":{\"name\":\"Car page Url\",\"value\":\"https://www.carspecs.us/cars/1999/oldsmobile/aurora/7802\"},\"objectPositionHorizontal\":{\"name\":\"Object horizontal position\",\"value\":\"0vh\"},\"objectPositionVertical\":{\"name\":\"Object vertical position\",\"value\":\"0vh\"},\"objectWidth\":{\"name\":\"Object width\",\"value\":\"100%\"},\"objectHeight\":{\"name\":\"Object height\",\"value\":\"100%\"},\"gear1st\":{\"name\":\"1st gear\",\"value\":2.96},\"gear2nd\":{\"name\":\"2nd gear\",\"value\":1.63},\"gear3rd\":{\"name\":\"3rd gear\",\"value\":1.0},\"gear4th\":{\"name\":\"4th gear\",\"value\":0.68},\"gear5th\":{\"name\":\"5th gear\",\"value\":-1.0},\"gear6th\":{\"name\":\"6th gear\",\"value\":-1.0},\"finalDrive\":{\"name\":\"Final drive\",\"value\":3.48},\"abs\":{\"name\":\"ABS\",\"value\":\"yes\"}},{\"id\":\"2015_bentley_continental-gt3-r_44722\",\"manufacturer\":{\"name\":\"Manufacturer\",\"value\":\"Bentley\"},\"type\":{\"name\":\"Car type\",\"value\":\"Continental GT3-R 4.0L V8 Twin turbo\"},\"year\":{\"name\":\"Year\",\"value\":2015},\"doors\":{\"name\":\"Doors\",\"value\":-1},\"body\":{\"name\":\"Body type\",\"value\":\"Coupe\"},\"seats\":{\"name\":\"Seats\",\"value\":-1},\"driveWheel\":{\"name\":\"Drive wheel\",\"value\":\"4WD\"},\"engineType\":{\"name\":\"Engine type\",\"value\":\"Gas\"},\"fuelType\":{\"name\":\"Fuel type\",\"value\":\"N/A\"},\"fuelTankCapacity\":{\"name\":\"Fuel tank capacity\",\"value\":90},\"engineCapacity\":{\"name\":\"Engine capacity (cm<sup>3</sup>)\",\"value\":4000},\"powerKW\":{\"name\":\"Power (KW)\",\"value\":426},\"powerHP\":{\"name\":\"Power (HP)\",\"value\":572},\"maxTorque\":{\"name\":\"Max Torque (Nm)\",\"value\":702},\"topSpeed\":{\"name\":\"Top speed (km/h)\",\"value\":-1},\"acceleration\":{\"name\":\"0-100 (km/h)\",\"value\":4.27},\"weight\":{\"name\":\"Weight (kg)\",\"value\":2194},\"length\":{\"name\":\"Length (mm)\",\"value\":4800},\"width\":{\"name\":\"Width (mm)\",\"value\":1930},\"height\":{\"name\":\"Height (mm)\",\"value\":1397},\"groundClearance\":{\"name\":\"Ground clearence (mm)\",\"value\":-25},\"tractionControl\":{\"name\":\"Traction control\",\"value\":\"yes\"},\"imageUrl\":{\"name\":\"Car image URL\",\"value\":\"https://www.carspecs.us/photos/e0b374d39f26e28552686a9b1943173e01d2c553-2000.jpg\"},\"logoURL\":{\"name\":\"Manufacturer Logo URL\",\"value\":\"N/A\"},\"carPageUrl\":{\"name\":\"Car page Url\",\"value\":\"https://www.carspecs.us/cars/2015/bentley/continental-gt3-r/44722\"},\"objectPositionHorizontal\":{\"name\":\"Object horizontal position\",\"value\":\"0vh\"},\"objectPositionVertical\":{\"name\":\"Object vertical position\",\"value\":\"0vh\"},\"objectWidth\":{\"name\":\"Object width\",\"value\":\"100%\"},\"objectHeight\":{\"name\":\"Object height\",\"value\":\"100%\"},\"gear1st\":{\"name\":\"1st gear\",\"value\":-1.0},\"gear2nd\":{\"name\":\"2nd gear\",\"value\":-1.0},\"gear3rd\":{\"name\":\"3rd gear\",\"value\":-1.0},\"gear4th\":{\"name\":\"4th gear\",\"value\":-1.0},\"gear5th\":{\"name\":\"5th gear\",\"value\":-1.0},\"gear6th\":{\"name\":\"6th gear\",\"value\":-1.0},\"finalDrive\":{\"name\":\"Final drive\",\"value\":-1.0},\"abs\":{\"name\":\"ABS\",\"value\":\"N/A\"}},{\"id\":\"2003_aston-martin_db7-vantage_12032\",\"manufacturer\":{\"name\":\"Manufacturer\",\"value\":\"Aston Martin\"},\"type\":{\"name\":\"Car type\",\"value\":\"DB7 Vantage Volante\"},\"year\":{\"name\":\"Year\",\"value\":2003},\"doors\":{\"name\":\"Doors\",\"value\":-1},\"body\":{\"name\":\"Body type\",\"value\":\"Convertible\"},\"seats\":{\"name\":\"Seats\",\"value\":-1},\"driveWheel\":{\"name\":\"Drive wheel\",\"value\":\"RWD\"},\"engineType\":{\"name\":\"Engine type\",\"value\":\"N/A\"},\"fuelType\":{\"name\":\"Fuel type\",\"value\":\"N/A\"},\"fuelTankCapacity\":{\"name\":\"Fuel tank capacity\",\"value\":81},\"engineCapacity\":{\"name\":\"Engine capacity (cm<sup>3</sup>)\",\"value\":-1000},\"powerKW\":{\"name\":\"Power (KW)\",\"value\":313},\"powerHP\":{\"name\":\"Power (HP)\",\"value\":420},\"maxTorque\":{\"name\":\"Max Torque (Nm)\",\"value\":-1},\"topSpeed\":{\"name\":\"Top speed (km/h)\",\"value\":-1},\"acceleration\":{\"name\":\"0-100 (km/h)\",\"value\":4.62},\"weight\":{\"name\":\"Weight (kg)\",\"value\":1860},\"length\":{\"name\":\"Length (mm)\",\"value\":-25},\"width\":{\"name\":\"Width (mm)\",\"value\":-25},\"height\":{\"name\":\"Height (mm)\",\"value\":-25},\"groundClearance\":{\"name\":\"Ground clearence (mm)\",\"value\":-25},\"tractionControl\":{\"name\":\"Traction control\",\"value\":\"N/A\"},\"imageUrl\":{\"name\":\"Car image URL\",\"value\":\"https://www.carspecs.us/photos/df342eb3e32b595c2f3cc38359ac4d3da15e13a0-2000.jpg\"},\"logoURL\":{\"name\":\"Manufacturer Logo URL\",\"value\":\"N/A\"},\"carPageUrl\":{\"name\":\"Car page Url\",\"value\":\"https://www.carspecs.us/cars/2003/aston-martin/db7-vantage/12032\"},\"objectPositionHorizontal\":{\"name\":\"Object horizontal position\",\"value\":\"0vh\"},\"objectPositionVertical\":{\"name\":\"Object vertical position\",\"value\":\"0vh\"},\"objectWidth\":{\"name\":\"Object width\",\"value\":\"100%\"},\"objectHeight\":{\"name\":\"Object height\",\"value\":\"100%\"},\"gear1st\":{\"name\":\"1st gear\",\"value\":-1.0},\"gear2nd\":{\"name\":\"2nd gear\",\"value\":-1.0},\"gear3rd\":{\"name\":\"3rd gear\",\"value\":-1.0},\"gear4th\":{\"name\":\"4th gear\",\"value\":-1.0},\"gear5th\":{\"name\":\"5th gear\",\"value\":-1.0},\"gear6th\":{\"name\":\"6th gear\",\"value\":-1.0},\"finalDrive\":{\"name\":\"Final drive\",\"value\":-1.0},\"abs\":{\"name\":\"ABS\",\"value\":\"N/A\"}},{\"id\":\"suzuki-swift-1-5-gls_47270\",\"manufacturer\":{\"name\":\"Manufacturer\",\"value\":\"Suzuki\"},\"type\":{\"name\":\"Car type\",\"value\":\"Swift 1.5 GLS\"},\"year\":{\"name\":\"Year\",\"value\":2005},\"doors\":{\"name\":\"Doors\",\"value\":5},\"body\":{\"name\":\"Body type\",\"value\":\"hatchback\"},\"seats\":{\"name\":\"Seats\",\"value\":5},\"driveWheel\":{\"name\":\"Drive wheel\",\"value\":\"FWD\"},\"engineType\":{\"name\":\"Engine type\",\"value\":\"fuel engine\"},\"fuelType\":{\"name\":\"Fuel type\",\"value\":\"gasoline\"},\"fuelTankCapacity\":{\"name\":\"Fuel tank capacity\",\"value\":45},\"engineCapacity\":{\"name\":\"Engine capacity (cm<sup>3</sup>)\",\"value\":1490},\"powerKW\":{\"name\":\"Power (KW)\",\"value\":75},\"powerHP\":{\"name\":\"Power (HP)\",\"value\":102},\"maxTorque\":{\"name\":\"Max Torque (Nm)\",\"value\":133},\"topSpeed\":{\"name\":\"Top speed (km/h)\",\"value\":185},\"acceleration\":{\"name\":\"0-100 (km/h)\",\"value\":10.0},\"weight\":{\"name\":\"Weight (kg)\",\"value\":975},\"length\":{\"name\":\"Length (mm)\",\"value\":3695},\"width\":{\"name\":\"Width (mm)\",\"value\":1690},\"height\":{\"name\":\"Height (mm)\",\"value\":1500},\"groundClearance\":{\"name\":\"Ground clearence (mm)\",\"value\":-1},\"tractionControl\":{\"name\":\"Traction control\",\"value\":\"N/A\"},\"imageUrl\":{\"name\":\"Car image URL\",\"value\":\"https://www.cars-data.com/webp/thumbs/350px/suzuki/suzuki-swift_2559_4.webp\"},\"logoURL\":{\"name\":\"Manufacturer Logo URL\",\"value\":\"https://www.cars-data.com/design/images/cars-logo/suzuki-logo-small.jpg\"},\"carPageUrl\":{\"name\":\"Car page Url\",\"value\":\"https://www.cars-data.com/en/suzuki-swift-1-5-gls-specs/47270\"},\"objectPositionHorizontal\":{\"name\":\"Object horizontal position\",\"value\":\"0vh\"},\"objectPositionVertical\":{\"name\":\"Object vertical position\",\"value\":\"0vh\"},\"objectWidth\":{\"name\":\"Object width\",\"value\":\"100%\"},\"objectHeight\":{\"name\":\"Object height\",\"value\":\"100%\"},\"gear1st\":{\"name\":\"1st gear\",\"value\":3.55},\"gear2nd\":{\"name\":\"2nd gear\",\"value\":1.9},\"gear3rd\":{\"name\":\"3rd gear\",\"value\":1.31},\"gear4th\":{\"name\":\"4th gear\",\"value\":0.97},\"gear5th\":{\"name\":\"5th gear\",\"value\":0.77},\"gear6th\":{\"name\":\"6th gear\",\"value\":-1.0},\"finalDrive\":{\"name\":\"Final drive\",\"value\":4.11},\"abs\":{\"name\":\"ABS\",\"value\":\"yes\"}},{\"id\":\"audi-a8-55-tfsi-quattro_80368\",\"manufacturer\":{\"name\":\"Manufacturer\",\"value\":\"Audi\"},\"type\":{\"name\":\"Car type\",\"value\":\"A8 55 TFSI quattro\"},\"year\":{\"name\":\"Year\",\"value\":2017},\"doors\":{\"name\":\"Doors\",\"value\":4},\"body\":{\"name\":\"Body type\",\"value\":\"sedan\"},\"seats\":{\"name\":\"Seats\",\"value\":5},\"driveWheel\":{\"name\":\"Drive wheel\",\"value\":\"4WD\"},\"engineType\":{\"name\":\"Engine type\",\"value\":\"fuel engine\"},\"fuelType\":{\"name\":\"Fuel type\",\"value\":\"gasoline\"},\"fuelTankCapacity\":{\"name\":\"Fuel tank capacity\",\"value\":72},\"engineCapacity\":{\"name\":\"Engine capacity (cm<sup>3</sup>)\",\"value\":2995},\"powerKW\":{\"name\":\"Power (KW)\",\"value\":250},\"powerHP\":{\"name\":\"Power (HP)\",\"value\":340},\"maxTorque\":{\"name\":\"Max Torque (Nm)\",\"value\":500},\"topSpeed\":{\"name\":\"Top speed (km/h)\",\"value\":250},\"acceleration\":{\"name\":\"0-100 (km/h)\",\"value\":5.6},\"weight\":{\"name\":\"Weight (kg)\",\"value\":1895},\"length\":{\"name\":\"Length (mm)\",\"value\":5172},\"width\":{\"name\":\"Width (mm)\",\"value\":1945},\"height\":{\"name\":\"Height (mm)\",\"value\":1473},\"groundClearance\":{\"name\":\"Ground clearence (mm)\",\"value\":-1},\"tractionControl\":{\"name\":\"Traction control\",\"value\":\"yes\"},\"imageUrl\":{\"name\":\"Car image URL\",\"value\":\"https://www.cars-data.com/webp/thumbs/350px/audi/audi-a8_4133_10.webp\"},\"logoURL\":{\"name\":\"Manufacturer Logo URL\",\"value\":\"https://www.cars-data.com/design/images/cars-logo/audi-logo-small.jpg\"},\"carPageUrl\":{\"name\":\"Car page Url\",\"value\":\"https://www.cars-data.com/en/audi-a8-55-tfsi-quattro-specs/80368\"},\"objectPositionHorizontal\":{\"name\":\"Object horizontal position\",\"value\":\"0vh\"},\"objectPositionVertical\":{\"name\":\"Object vertical position\",\"value\":\"0vh\"},\"objectWidth\":{\"name\":\"Object width\",\"value\":\"100%\"},\"objectHeight\":{\"name\":\"Object height\",\"value\":\"100%\"},\"gear1st\":{\"name\":\"1st gear\",\"value\":4.71},\"gear2nd\":{\"name\":\"2nd gear\",\"value\":3.14},\"gear3rd\":{\"name\":\"3rd gear\",\"value\":2.11},\"gear4th\":{\"name\":\"4th gear\",\"value\":1.67},\"gear5th\":{\"name\":\"5th gear\",\"value\":1.29},\"gear6th\":{\"name\":\"6th gear\",\"value\":1.0},\"finalDrive\":{\"name\":\"Final drive\",\"value\":3.08},\"abs\":{\"name\":\"ABS\",\"value\":\"yes\"}},{\"id\":\"suzuki-liana-1-6-glx_47096\",\"manufacturer\":{\"name\":\"Manufacturer\",\"value\":\"Suzuki\"},\"type\":{\"name\":\"Car type\",\"value\":\"Liana 1.6 GLX\"},\"year\":{\"name\":\"Year\",\"value\":2002},\"doors\":{\"name\":\"Doors\",\"value\":4},\"body\":{\"name\":\"Body type\",\"value\":\"sedan\"},\"seats\":{\"name\":\"Seats\",\"value\":5},\"driveWheel\":{\"name\":\"Drive wheel\",\"value\":\"FWD\"},\"engineType\":{\"name\":\"Engine type\",\"value\":\"fuel engine\"},\"fuelType\":{\"name\":\"Fuel type\",\"value\":\"gasoline\"},\"fuelTankCapacity\":{\"name\":\"Fuel tank capacity\",\"value\":50},\"engineCapacity\":{\"name\":\"Engine capacity (cm<sup>3</sup>)\",\"value\":1586},\"powerKW\":{\"name\":\"Power (KW)\",\"value\":76},\"powerHP\":{\"name\":\"Power (HP)\",\"value\":103},\"maxTorque\":{\"name\":\"Max Torque (Nm)\",\"value\":144},\"topSpeed\":{\"name\":\"Top speed (km/h)\",\"value\":170},\"acceleration\":{\"name\":\"0-100 (km/h)\",\"value\":-1.0},\"weight\":{\"name\":\"Weight (kg)\",\"value\":1110},\"length\":{\"name\":\"Length (mm)\",\"value\":4350},\"width\":{\"name\":\"Width (mm)\",\"value\":1690},\"height\":{\"name\":\"Height (mm)\",\"value\":1545},\"groundClearance\":{\"name\":\"Ground clearence (mm)\",\"value\":160},\"tractionControl\":{\"name\":\"Traction control\",\"value\":\"N/A\"},\"imageUrl\":{\"name\":\"Car image URL\",\"value\":\"https://www.cars-data.com/webp/thumbs/350px/suzuki/suzuki-liana_2538_2.webp\"},\"logoURL\":{\"name\":\"Manufacturer Logo URL\",\"value\":\"https://www.cars-data.com/design/images/cars-logo/suzuki-logo-small.jpg\"},\"carPageUrl\":{\"name\":\"Car page Url\",\"value\":\"https://www.cars-data.com/en/suzuki-liana-1-6-glx-specs/47096\"},\"objectPositionHorizontal\":{\"name\":\"Object horizontal position\",\"value\":\"0vh\"},\"objectPositionVertical\":{\"name\":\"Object vertical position\",\"value\":\"0vh\"},\"objectWidth\":{\"name\":\"Object width\",\"value\":\"100%\"},\"objectHeight\":{\"name\":\"Object height\",\"value\":\"100%\"},\"gear1st\":{\"name\":\"1st gear\",\"value\":3.55},\"gear2nd\":{\"name\":\"2nd gear\",\"value\":1.9},\"gear3rd\":{\"name\":\"3rd gear\",\"value\":1.31},\"gear4th\":{\"name\":\"4th gear\",\"value\":0.97},\"gear5th\":{\"name\":\"5th gear\",\"value\":0.82},\"gear6th\":{\"name\":\"6th gear\",\"value\":-1.0},\"finalDrive\":{\"name\":\"Final drive\",\"value\":4.11},\"abs\":{\"name\":\"ABS\",\"value\":\"yes\"}},{\"id\":\"aston-martin-vantage_79941\",\"manufacturer\":{\"name\":\"Manufacturer\",\"value\":\"Aston Martin\"},\"type\":{\"name\":\"Car type\",\"value\":\"Vantage\"},\"year\":{\"name\":\"Year\",\"value\":2018},\"doors\":{\"name\":\"Doors\",\"value\":2},\"body\":{\"name\":\"Body type\",\"value\":\"coup&eacute;\"},\"seats\":{\"name\":\"Seats\",\"value\":2},\"driveWheel\":{\"name\":\"Drive wheel\",\"value\":\"RWD\"},\"engineType\":{\"name\":\"Engine type\",\"value\":\"fuel engine\"},\"fuelType\":{\"name\":\"Fuel type\",\"value\":\"gasoline\"},\"fuelTankCapacity\":{\"name\":\"Fuel tank capacity\",\"value\":73},\"engineCapacity\":{\"name\":\"Engine capacity (cm<sup>3</sup>)\",\"value\":4000},\"powerKW\":{\"name\":\"Power (KW)\",\"value\":375},\"powerHP\":{\"name\":\"Power (HP)\",\"value\":510},\"maxTorque\":{\"name\":\"Max Torque (Nm)\",\"value\":685},\"topSpeed\":{\"name\":\"Top speed (km/h)\",\"value\":314},\"acceleration\":{\"name\":\"0-100 (km/h)\",\"value\":3.6},\"weight\":{\"name\":\"Weight (kg)\",\"value\":1530},\"length\":{\"name\":\"Length (mm)\",\"value\":4465},\"width\":{\"name\":\"Width (mm)\",\"value\":1942},\"height\":{\"name\":\"Height (mm)\",\"value\":1273},\"groundClearance\":{\"name\":\"Ground clearence (mm)\",\"value\":-1},\"tractionControl\":{\"name\":\"Traction control\",\"value\":\"yes\"},\"imageUrl\":{\"name\":\"Car image URL\",\"value\":\"https://www.cars-data.com/webp/thumbs/350px/aston-martin/aston-martin-vantage_4120_9.webp\"},\"logoURL\":{\"name\":\"Manufacturer Logo URL\",\"value\":\"https://www.cars-data.com/design/images/cars-logo/aston-martin-logo-small.jpg\"},\"carPageUrl\":{\"name\":\"Car page Url\",\"value\":\"https://www.cars-data.com/en/aston-martin-vantage-specs/79941\"},\"objectPositionHorizontal\":{\"name\":\"Object horizontal position\",\"value\":\"0vh\"},\"objectPositionVertical\":{\"name\":\"Object vertical position\",\"value\":\"0vh\"},\"objectWidth\":{\"name\":\"Object width\",\"value\":\"100%\"},\"objectHeight\":{\"name\":\"Object height\",\"value\":\"100%\"},\"gear1st\":{\"name\":\"1st gear\",\"value\":4.71},\"gear2nd\":{\"name\":\"2nd gear\",\"value\":3.14},\"gear3rd\":{\"name\":\"3rd gear\",\"value\":2.11},\"gear4th\":{\"name\":\"4th gear\",\"value\":1.67},\"gear5th\":{\"name\":\"5th gear\",\"value\":1.28},\"gear6th\":{\"name\":\"6th gear\",\"value\":1.0},\"finalDrive\":{\"name\":\"Final drive\",\"value\":2.93},\"abs\":{\"name\":\"ABS\",\"value\":\"yes\"}}]\n";
    ObjectMapper mapper = new ObjectMapper();

    try {
      JsonNode node = mapper.readTree(json);
      return node;

    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
    /// tesztre
  }


  @PostMapping
  public CardDTO createCard(@RequestBody CreateCardCommand command) {

      CardDTO card = ccGameService.createCard(command);
      System.out.println(card);
    return card;
  }


  @PutMapping("/{id}")
  public CardDTO updateCard(@PathVariable String id, @RequestBody UpdateCardCommand command) {

    return ccGameService.updateCard(id, command);
  }


    @DeleteMapping
    public void removeCard(@RequestBody RemoveCardCommand command) {

        ccGameService.removeCard(command);
    }
}

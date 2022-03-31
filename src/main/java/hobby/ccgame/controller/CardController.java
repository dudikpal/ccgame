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

    private final String json = "[{\"id\":\"c_mercury-sable-stationwagon-ls_59813\",\"manufacturer\":\"Mercury\",\"type\":\"Sable Stationwagon LS\",\"year\":1992,\"country\":\"N/A\",\"doors\":5,\"body\":\"station wagon\",\"seats\":5,\"driveWheel\":\"FWD\",\"engineType\":\"fuel engine\",\"fuelType\":\"gasoline\",\"fuelTankCapacity\":61,\"engineCapacity\":3797,\"powerKW\":104,\"powerHP\":141,\"maxTorque\":292,\"topSpeed\":180,\"acceleration\":-1.0,\"weight\":1580,\"length\":4910,\"width\":1810,\"height\":1400,\"groundClearance\":-1,\"tractionControl\":\"N/A\",\"imageUrl\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnmDON_IsijFf6t_xUDDUk4cKPjYgJufhcXA&usqp=CAU\",\"logoURL\":\"https://www.cars-data.com/design/images/cars-logo/mercury-logo-small.jpg\",\"carPageUrl\":\"https://www.cars-data.com/en/mercury-sable-stationwagon-ls-specs/59813\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":2.77,\"gear2nd\":1.54,\"gear3rd\":1.0,\"gear4th\":0.69,\"gear5th\":-1.0,\"gear6th\":-1.0,\"finalDrive\":3.37,\"abs\":\"yes\"},{\"id\":\"c_2007_audi_a4_71215\",\"manufacturer\":\"Audi\",\"type\":\"A4 2.0T\",\"year\":2007,\"country\":\"N/A\",\"doors\":4,\"body\":\"Sedan\",\"seats\":5,\"driveWheel\":\"FWD\",\"engineType\":\"Gas\",\"fuelType\":\"N/A\",\"fuelTankCapacity\":70,\"engineCapacity\":2000,\"powerKW\":149,\"powerHP\":200,\"maxTorque\":280,\"topSpeed\":-1,\"acceleration\":7.58,\"weight\":1544,\"length\":4572,\"width\":1752,\"height\":1422,\"groundClearance\":101,\"tractionControl\":\"N/A\",\"imageUrl\":\"https://auto-types.com/wp-content/uploads/_cars/2021/01/audi-qfb7c25.jpg\",\"logoURL\":\"N/A\",\"carPageUrl\":\"https://www.carspecs.us/cars/2007/audi/a4/71215\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":3.67,\"gear2nd\":2.05,\"gear3rd\":1.37,\"gear4th\":1.03,\"gear5th\":0.8,\"gear6th\":0.66,\"finalDrive\":3.75,\"abs\":\"yes\"},{\"id\":\"c_2014_dodge_avenger_35821\",\"manufacturer\":\"Dodge\",\"type\":\"Avenger V6\",\"year\":2014,\"country\":\"N/A\",\"doors\":-1,\"body\":\"Sedan\",\"seats\":-1,\"driveWheel\":\"FWD\",\"engineType\":\"Flex Fuel\",\"fuelType\":\"N/A\",\"fuelTankCapacity\":63,\"engineCapacity\":3600,\"powerKW\":211,\"powerHP\":283,\"maxTorque\":352,\"topSpeed\":-1,\"acceleration\":6.56,\"weight\":1636,\"length\":4876,\"width\":1828,\"height\":1473,\"groundClearance\":152,\"tractionControl\":\"yes\",\"imageUrl\":\"https://www.carspecs.us/photos/1788f258b325d388020a443a59440ad7c82ec6ec-2000.jpg\",\"logoURL\":\"N/A\",\"carPageUrl\":\"https://www.carspecs.us/cars/2014/dodge/avenger/35821\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":-1.0,\"gear2nd\":-1.0,\"gear3rd\":-1.0,\"gear4th\":-1.0,\"gear5th\":-1.0,\"gear6th\":-1.0,\"finalDrive\":-1.0,\"abs\":\"yes\"},{\"id\":\"c_1991_volvo_940_36963\",\"manufacturer\":\"Volvo\",\"type\":\"940 SE  Turbo\",\"year\":1991,\"country\":\"N/A\",\"doors\":-1,\"body\":\"Sedan\",\"seats\":-1,\"driveWheel\":\"RWD\",\"engineType\":\"Gas\",\"fuelType\":\"N/A\",\"fuelTankCapacity\":79,\"engineCapacity\":2300,\"powerKW\":120,\"powerHP\":162,\"maxTorque\":264,\"topSpeed\":-1,\"acceleration\":8.62,\"weight\":1499,\"length\":4851,\"width\":1752,\"height\":1397,\"groundClearance\":101,\"tractionControl\":\"N/A\",\"imageUrl\":\"https://www.carspecs.us/photos/071902b9dff386a2fa002262defabde2064e7b80-2000.jpg\",\"logoURL\":\"N/A\",\"carPageUrl\":\"https://www.carspecs.us/cars/1991/volvo/940/36963\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":-1.0,\"gear2nd\":-1.0,\"gear3rd\":-1.0,\"gear4th\":-1.0,\"gear5th\":-1.0,\"gear6th\":-1.0,\"finalDrive\":-1.0,\"abs\":\"N/A\"},{\"id\":\"c_1999_oldsmobile_aurora_7802\",\"manufacturer\":\"Oldsmobile\",\"type\":\"Aurora V8\",\"year\":1999,\"country\":\"N/A\",\"doors\":4,\"body\":\"Sedan\",\"seats\":5,\"driveWheel\":\"FWD\",\"engineType\":\"Gas\",\"fuelType\":\"N/A\",\"fuelTankCapacity\":70,\"engineCapacity\":4000,\"powerKW\":186,\"powerHP\":250,\"maxTorque\":352,\"topSpeed\":-1,\"acceleration\":7.63,\"weight\":1770,\"length\":5207,\"width\":1879,\"height\":1397,\"groundClearance\":127,\"tractionControl\":\"N/A\",\"imageUrl\":\"https://www.carspecs.us/photos/15dfb0b05a2431c7711395ddd0273bce0c133742-2000.jpg\",\"logoURL\":\"N/A\",\"carPageUrl\":\"https://www.carspecs.us/cars/1999/oldsmobile/aurora/7802\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":2.96,\"gear2nd\":1.63,\"gear3rd\":1.0,\"gear4th\":0.68,\"gear5th\":-1.0,\"gear6th\":-1.0,\"finalDrive\":3.48,\"abs\":\"yes\"},{\"id\":\"c_2015_bentley_continental-gt3-r_44722\",\"manufacturer\":\"Bentley\",\"type\":\"Continental GT3-R V8 Twin turbo\",\"year\":2015,\"country\":\"N/A\",\"doors\":-1,\"body\":\"Coupe\",\"seats\":-1,\"driveWheel\":\"4WD\",\"engineType\":\"Gas\",\"fuelType\":\"N/A\",\"fuelTankCapacity\":90,\"engineCapacity\":4000,\"powerKW\":426,\"powerHP\":572,\"maxTorque\":702,\"topSpeed\":-1,\"acceleration\":4.27,\"weight\":2194,\"length\":4800,\"width\":1930,\"height\":1397,\"groundClearance\":-25,\"tractionControl\":\"yes\",\"imageUrl\":\"https://www.carspecs.us/photos/e0b374d39f26e28552686a9b1943173e01d2c553-2000.jpg\",\"logoURL\":\"N/A\",\"carPageUrl\":\"https://www.carspecs.us/cars/2015/bentley/continental-gt3-r/44722\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":-1.0,\"gear2nd\":-1.0,\"gear3rd\":-1.0,\"gear4th\":-1.0,\"gear5th\":-1.0,\"gear6th\":-1.0,\"finalDrive\":-1.0,\"abs\":\"N/A\"},{\"id\":\"c_2003_aston-martin_db7-vantage_12032\",\"manufacturer\":\"Aston Martin\",\"type\":\"DB7 Vantage Volante\",\"year\":2003,\"country\":\"N/A\",\"doors\":-1,\"body\":\"Convertible\",\"seats\":-1,\"driveWheel\":\"RWD\",\"engineType\":\"N/A\",\"fuelType\":\"N/A\",\"fuelTankCapacity\":81,\"engineCapacity\":-1000,\"powerKW\":313,\"powerHP\":420,\"maxTorque\":-1,\"topSpeed\":-1,\"acceleration\":4.62,\"weight\":1860,\"length\":-25,\"width\":-25,\"height\":-25,\"groundClearance\":-25,\"tractionControl\":\"N/A\",\"imageUrl\":\"https://www.carspecs.us/photos/df342eb3e32b595c2f3cc38359ac4d3da15e13a0-2000.jpg\",\"logoURL\":\"N/A\",\"carPageUrl\":\"https://www.carspecs.us/cars/2003/aston-martin/db7-vantage/12032\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":-1.0,\"gear2nd\":-1.0,\"gear3rd\":-1.0,\"gear4th\":-1.0,\"gear5th\":-1.0,\"gear6th\":-1.0,\"finalDrive\":-1.0,\"abs\":\"N/A\"},{\"id\":\"c_suzuki-swift-1-5-gls_47270\",\"manufacturer\":\"Suzuki\",\"type\":\"Swift 1.5 GLS\",\"year\":2005,\"country\":\"N/A\",\"doors\":5,\"body\":\"hatchback\",\"seats\":5,\"driveWheel\":\"FWD\",\"engineType\":\"fuel engine\",\"fuelType\":\"gasoline\",\"fuelTankCapacity\":45,\"engineCapacity\":1490,\"powerKW\":75,\"powerHP\":102,\"maxTorque\":133,\"topSpeed\":185,\"acceleration\":10.0,\"weight\":975,\"length\":3695,\"width\":1690,\"height\":1500,\"groundClearance\":-1,\"tractionControl\":\"N/A\",\"imageUrl\":\"https://www.cars-data.com/webp/thumbs/350px/suzuki/suzuki-swift_2559_4.webp\",\"logoURL\":\"https://www.cars-data.com/design/images/cars-logo/suzuki-logo-small.jpg\",\"carPageUrl\":\"https://www.cars-data.com/en/suzuki-swift-1-5-gls-specs/47270\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":3.55,\"gear2nd\":1.9,\"gear3rd\":1.31,\"gear4th\":0.97,\"gear5th\":0.77,\"gear6th\":-1.0,\"finalDrive\":4.11,\"abs\":\"yes\"},{\"id\":\"c_audi-a8-55-tfsi-quattro_80368\",\"manufacturer\":\"Audi\",\"type\":\"A8 55 TFSI quattro\",\"year\":2017,\"country\":\"N/A\",\"doors\":4,\"body\":\"sedan\",\"seats\":5,\"driveWheel\":\"4WD\",\"engineType\":\"fuel engine\",\"fuelType\":\"gasoline\",\"fuelTankCapacity\":72,\"engineCapacity\":2995,\"powerKW\":250,\"powerHP\":340,\"maxTorque\":500,\"topSpeed\":250,\"acceleration\":5.6,\"weight\":1895,\"length\":5172,\"width\":1945,\"height\":1473,\"groundClearance\":-1,\"tractionControl\":\"yes\",\"imageUrl\":\"https://www.cars-data.com/webp/thumbs/350px/audi/audi-a8_4133_10.webp\",\"logoURL\":\"https://www.cars-data.com/design/images/cars-logo/audi-logo-small.jpg\",\"carPageUrl\":\"https://www.cars-data.com/en/audi-a8-55-tfsi-quattro-specs/80368\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":4.71,\"gear2nd\":3.14,\"gear3rd\":2.11,\"gear4th\":1.67,\"gear5th\":1.29,\"gear6th\":1.0,\"finalDrive\":3.08,\"abs\":\"yes\"},{\"id\":\"c_suzuki-liana-1-6-glx_47096\",\"manufacturer\":\"Suzuki\",\"type\":\"Liana 1.6 GLX\",\"year\":2002,\"country\":\"N/A\",\"doors\":4,\"body\":\"sedan\",\"seats\":5,\"driveWheel\":\"FWD\",\"engineType\":\"fuel engine\",\"fuelType\":\"gasoline\",\"fuelTankCapacity\":50,\"engineCapacity\":1586,\"powerKW\":76,\"powerHP\":103,\"maxTorque\":144,\"topSpeed\":170,\"acceleration\":-1.0,\"weight\":1110,\"length\":4350,\"width\":1690,\"height\":1545,\"groundClearance\":160,\"tractionControl\":\"N/A\",\"imageUrl\":\"https://www.cars-data.com/webp/thumbs/350px/suzuki/suzuki-liana_2538_2.webp\",\"logoURL\":\"https://www.cars-data.com/design/images/cars-logo/suzuki-logo-small.jpg\",\"carPageUrl\":\"https://www.cars-data.com/en/suzuki-liana-1-6-glx-specs/47096\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":3.55,\"gear2nd\":1.9,\"gear3rd\":1.31,\"gear4th\":0.97,\"gear5th\":0.82,\"gear6th\":-1.0,\"finalDrive\":4.11,\"abs\":\"yes\"},{\"id\":\"c_aston-martin-vantage_79941\",\"manufacturer\":\"Aston Martin\",\"type\":\"Vantage\",\"year\":2018,\"country\":\"N/A\",\"doors\":2,\"body\":\"coup&eacute;\",\"seats\":2,\"driveWheel\":\"RWD\",\"engineType\":\"fuel engine\",\"fuelType\":\"gasoline\",\"fuelTankCapacity\":73,\"engineCapacity\":4000,\"powerKW\":375,\"powerHP\":510,\"maxTorque\":685,\"topSpeed\":314,\"acceleration\":3.6,\"weight\":1530,\"length\":4465,\"width\":1942,\"height\":1273,\"groundClearance\":-1,\"tractionControl\":\"yes\",\"imageUrl\":\"https://www.cars-data.com/webp/thumbs/350px/aston-martin/aston-martin-vantage_4120_9.webp\",\"logoURL\":\"https://www.cars-data.com/design/images/cars-logo/aston-martin-logo-small.jpg\",\"carPageUrl\":\"https://www.cars-data.com/en/aston-martin-vantage-specs/79941\",\"objectPositionHorizontal\":\"0vh\",\"objectPositionVertical\":\"0vh\",\"objectWidth\":\"100%\",\"objectHeight\":\"100%\",\"gear1st\":4.71,\"gear2nd\":3.14,\"gear3rd\":2.11,\"gear4th\":1.67,\"gear5th\":1.28,\"gear6th\":1.0,\"finalDrive\":2.93,\"abs\":\"yes\"}]";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCards(@RequestParam Optional<String> jsonData) {
        // élesre
        /*return ccGameService.getAllCards();*/

        // tesztre
        ObjectMapper mapper = new ObjectMapper();

        try {

            return mapper.writeValueAsString(ccGameService.getCards(jsonData));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
        // tesztre
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


    @DeleteMapping
    public void removeCard(@RequestBody RemoveCardCommand command) {

        ccGameService.removeCard(command);
    }


    @PostMapping("/uploadfile/{filename}")
    public List<CardDTO> uploadCardsFromFile(@PathVariable String filename) {
        return ccGameService.uploadCardsFromFile(filename);
    }
}

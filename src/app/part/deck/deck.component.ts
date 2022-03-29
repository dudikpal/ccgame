import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {EventService} from "../event.service";

@Component({
    selector: 'app-deck',
    templateUrl: './deck.component.html',
    styleUrls: ['./deck.component.css']
})
export class DeckComponent implements OnInit {

    // tesztre
/*    cards = [
        {
            "id": {
                "name": "ID",
                "value": "c_lincoln-continental_59792"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Lincoln"
            },
            "type": {
                "name": "Car type",
                "value": "Continental"
            },
            "year": {
                "name": "Year",
                "value": 1995
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": 4
            },
            "body": {
                "name": "Body type",
                "value": "sedan"
            },
            "seats": {
                "name": "Seats",
                "value": 5
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "FWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "fuel engine"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "gasoline"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 67
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 4603
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 194
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 264
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 359
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": -1
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": -1.0
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1760
            },
            "length": {
                "name": "Length (mm)",
                "value": 5240
            },
            "width": {
                "name": "Width (mm)",
                "value": 1870
            },
            "height": {
                "name": "Height (mm)",
                "value": 1420
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": -1
            },
            "abs": {
                "name": "ABS",
                "value": "yes"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "N/A"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/lincoln-continental_59792.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "https://www.cars-data.com/design/images/cars-logo/lincoln-logo-small.jpg"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.cars-data.com/en/lincoln-continental-specs/59792"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": 2.77
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": 1.54
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": 1.0
            },
            "gear4th": {
                "name": "4th gear",
                "value": 0.69
            },
            "gear5th": {
                "name": "5th gear",
                "value": -1.0
            },
            "gear6th": {
                "name": "6th gear",
                "value": -1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": 3.56
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_mercury-sable-stationwagon-ls_59813"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Mercury"
            },
            "type": {
                "name": "Car type",
                "value": "Sable Stationwagon LS"
            },
            "year": {
                "name": "Year",
                "value": 1992
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": 5
            },
            "body": {
                "name": "Body type",
                "value": "station wagon"
            },
            "seats": {
                "name": "Seats",
                "value": 5
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "FWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "fuel engine"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "gasoline"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 61
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 3797
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 104
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 141
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 292
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": 180
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": -1.0
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1580
            },
            "length": {
                "name": "Length (mm)",
                "value": 4910
            },
            "width": {
                "name": "Width (mm)",
                "value": 1810
            },
            "height": {
                "name": "Height (mm)",
                "value": 1400
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": -1
            },
            "abs": {
                "name": "ABS",
                "value": "yes"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "N/A"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/mercury-sable-stationwagon-ls_59813.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "https://www.cars-data.com/design/images/cars-logo/mercury-logo-small.jpg"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.cars-data.com/en/mercury-sable-stationwagon-ls-specs/59813"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": 2.77
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": 1.54
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": 1.0
            },
            "gear4th": {
                "name": "4th gear",
                "value": 0.69
            },
            "gear5th": {
                "name": "5th gear",
                "value": -1.0
            },
            "gear6th": {
                "name": "6th gear",
                "value": -1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": 3.37
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_suzuki-swift-1-5-gls_47270"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Suzuki"
            },
            "type": {
                "name": "Car type",
                "value": "Swift 1.5 GLS"
            },
            "year": {
                "name": "Year",
                "value": 2005
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": 5
            },
            "body": {
                "name": "Body type",
                "value": "hatchback"
            },
            "seats": {
                "name": "Seats",
                "value": 5
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "FWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "fuel engine"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "gasoline"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 45
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 1490
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 75
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 102
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 133
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": 185
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": 10.0
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 975
            },
            "length": {
                "name": "Length (mm)",
                "value": 3695
            },
            "width": {
                "name": "Width (mm)",
                "value": 1690
            },
            "height": {
                "name": "Height (mm)",
                "value": 1500
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": -1
            },
            "abs": {
                "name": "ABS",
                "value": "yes"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "N/A"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/suzuki-swift-1-5-gls_47270.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "https://www.cars-data.com/design/images/cars-logo/suzuki-logo-small.jpg"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.cars-data.com/en/suzuki-swift-1-5-gls-specs/47270"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": 3.55
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": 1.9
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": 1.31
            },
            "gear4th": {
                "name": "4th gear",
                "value": 0.97
            },
            "gear5th": {
                "name": "5th gear",
                "value": 0.77
            },
            "gear6th": {
                "name": "6th gear",
                "value": -1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": 4.11
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_audi-a8-55-tfsi-quattro_80368"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Audi"
            },
            "type": {
                "name": "Car type",
                "value": "A8 55 TFSI quattro"
            },
            "year": {
                "name": "Year",
                "value": 2017
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": 4
            },
            "body": {
                "name": "Body type",
                "value": "sedan"
            },
            "seats": {
                "name": "Seats",
                "value": 5
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "4WD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "fuel engine"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "gasoline"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 72
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 2995
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 250
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 340
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 500
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": 250
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": 5.6
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1895
            },
            "length": {
                "name": "Length (mm)",
                "value": 5172
            },
            "width": {
                "name": "Width (mm)",
                "value": 1945
            },
            "height": {
                "name": "Height (mm)",
                "value": 1473
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": -1
            },
            "abs": {
                "name": "ABS",
                "value": "yes"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "yes"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/audi-a8-55-tfsi-quattro_80368.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "https://www.cars-data.com/design/images/cars-logo/audi-logo-small.jpg"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.cars-data.com/en/audi-a8-55-tfsi-quattro-specs/80368"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": 4.71
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": 3.14
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": 2.11
            },
            "gear4th": {
                "name": "4th gear",
                "value": 1.67
            },
            "gear5th": {
                "name": "5th gear",
                "value": 1.29
            },
            "gear6th": {
                "name": "6th gear",
                "value": 1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": 3.08
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_suzuki-liana-1-6-glx_47096"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Suzuki"
            },
            "type": {
                "name": "Car type",
                "value": "Liana 1.6 GLX"
            },
            "year": {
                "name": "Year",
                "value": 2002
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": 4
            },
            "body": {
                "name": "Body type",
                "value": "sedan"
            },
            "seats": {
                "name": "Seats",
                "value": 5
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "FWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "fuel engine"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "gasoline"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 50
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 1586
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 76
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 103
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 144
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": 170
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": -1.0
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1110
            },
            "length": {
                "name": "Length (mm)",
                "value": 4350
            },
            "width": {
                "name": "Width (mm)",
                "value": 1690
            },
            "height": {
                "name": "Height (mm)",
                "value": 1545
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": 160
            },
            "abs": {
                "name": "ABS",
                "value": "yes"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "N/A"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/suzuki-liana-1-6-glx_47096.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "https://www.cars-data.com/design/images/cars-logo/suzuki-logo-small.jpg"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.cars-data.com/en/suzuki-liana-1-6-glx-specs/47096"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": 3.55
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": 1.9
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": 1.31
            },
            "gear4th": {
                "name": "4th gear",
                "value": 0.97
            },
            "gear5th": {
                "name": "5th gear",
                "value": 0.82
            },
            "gear6th": {
                "name": "6th gear",
                "value": -1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": 4.11
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_aston-martin-vantage_79941"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Aston Martin"
            },
            "type": {
                "name": "Car type",
                "value": "Vantage"
            },
            "year": {
                "name": "Year",
                "value": 2018
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": 2
            },
            "body": {
                "name": "Body type",
                "value": "coup&eacute;"
            },
            "seats": {
                "name": "Seats",
                "value": 2
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "RWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "fuel engine"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "gasoline"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 73
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 4000
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 375
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 510
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 685
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": 314
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": 3.6
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1530
            },
            "length": {
                "name": "Length (mm)",
                "value": 4465
            },
            "width": {
                "name": "Width (mm)",
                "value": 1942
            },
            "height": {
                "name": "Height (mm)",
                "value": 1273
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": -1
            },
            "abs": {
                "name": "ABS",
                "value": "yes"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "yes"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/aston-martin-vantage_79941.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "https://www.cars-data.com/design/images/cars-logo/aston-martin-logo-small.jpg"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.cars-data.com/en/aston-martin-vantage-specs/79941"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": 4.71
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": 3.14
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": 2.11
            },
            "gear4th": {
                "name": "4th gear",
                "value": 1.67
            },
            "gear5th": {
                "name": "5th gear",
                "value": 1.28
            },
            "gear6th": {
                "name": "6th gear",
                "value": 1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": 2.93
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_1992_buick_park-avenue_36"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Buick"
            },
            "type": {
                "name": "Car type",
                "value": "Park Avenue Ultra  V6 Supercharger"
            },
            "year": {
                "name": "Year",
                "value": 1992
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": -1
            },
            "body": {
                "name": "Body type",
                "value": "Sedan"
            },
            "seats": {
                "name": "Seats",
                "value": -1
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "FWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "Gas"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "N/A"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 68
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 3800
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 152
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 205
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 352
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": -1
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": 8.41
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1651
            },
            "length": {
                "name": "Length (mm)",
                "value": 5207
            },
            "width": {
                "name": "Width (mm)",
                "value": 1854
            },
            "height": {
                "name": "Height (mm)",
                "value": 1397
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": 127
            },
            "abs": {
                "name": "ABS",
                "value": "N/A"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "N/A"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/1992_buick_park-avenue_36.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "N/A"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.carspecs.us/cars/1992/buick/park-avenue/36"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": -1.0
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": -1.0
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": -1.0
            },
            "gear4th": {
                "name": "4th gear",
                "value": -1.0
            },
            "gear5th": {
                "name": "5th gear",
                "value": -1.0
            },
            "gear6th": {
                "name": "6th gear",
                "value": -1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": -1.0
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_2007_audi_a4_71215"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Audi"
            },
            "type": {
                "name": "Car type",
                "value": "A4 2.0T"
            },
            "year": {
                "name": "Year",
                "value": 2007
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": 4
            },
            "body": {
                "name": "Body type",
                "value": "Sedan"
            },
            "seats": {
                "name": "Seats",
                "value": 5
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "FWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "Gas"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "N/A"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 70
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 2000
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 149
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 200
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 280
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": -1
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": 7.58
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1544
            },
            "length": {
                "name": "Length (mm)",
                "value": 4572
            },
            "width": {
                "name": "Width (mm)",
                "value": 1752
            },
            "height": {
                "name": "Height (mm)",
                "value": 1422
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": 101
            },
            "abs": {
                "name": "ABS",
                "value": "yes"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "N/A"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/2007_audi_a4_71215.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "N/A"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.carspecs.us/cars/2007/audi/a4/71215"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": 3.67
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": 2.05
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": 1.37
            },
            "gear4th": {
                "name": "4th gear",
                "value": 1.03
            },
            "gear5th": {
                "name": "5th gear",
                "value": 0.8
            },
            "gear6th": {
                "name": "6th gear",
                "value": 0.66
            },
            "finalDrive": {
                "name": "Final drive",
                "value": 3.75
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_2014_dodge_avenger_35821"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Dodge"
            },
            "type": {
                "name": "Car type",
                "value": "Avenger V6"
            },
            "year": {
                "name": "Year",
                "value": 2014
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": -1
            },
            "body": {
                "name": "Body type",
                "value": "Sedan"
            },
            "seats": {
                "name": "Seats",
                "value": -1
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "FWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "Flex Fuel"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "N/A"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 63
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 3600
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 211
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 283
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 352
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": -1
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": 6.56
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1636
            },
            "length": {
                "name": "Length (mm)",
                "value": 4876
            },
            "width": {
                "name": "Width (mm)",
                "value": 1828
            },
            "height": {
                "name": "Height (mm)",
                "value": 1473
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": 152
            },
            "abs": {
                "name": "ABS",
                "value": "yes"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "yes"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/2014_dodge_avenger_35821.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "N/A"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.carspecs.us/cars/2014/dodge/avenger/35821"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": -1.0
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": -1.0
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": -1.0
            },
            "gear4th": {
                "name": "4th gear",
                "value": -1.0
            },
            "gear5th": {
                "name": "5th gear",
                "value": -1.0
            },
            "gear6th": {
                "name": "6th gear",
                "value": -1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": -1.0
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_1991_volvo_940_36963"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Volvo"
            },
            "type": {
                "name": "Car type",
                "value": "940 SE  Turbo"
            },
            "year": {
                "name": "Year",
                "value": 1991
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": -1
            },
            "body": {
                "name": "Body type",
                "value": "Sedan"
            },
            "seats": {
                "name": "Seats",
                "value": -1
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "RWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "Gas"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "N/A"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 79
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 2300
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 120
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 162
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 264
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": -1
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": 8.62
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1499
            },
            "length": {
                "name": "Length (mm)",
                "value": 4851
            },
            "width": {
                "name": "Width (mm)",
                "value": 1752
            },
            "height": {
                "name": "Height (mm)",
                "value": 1397
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": 101
            },
            "abs": {
                "name": "ABS",
                "value": "N/A"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "N/A"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/1991_volvo_940_36963.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "N/A"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.carspecs.us/cars/1991/volvo/940/36963"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": -1.0
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": -1.0
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": -1.0
            },
            "gear4th": {
                "name": "4th gear",
                "value": -1.0
            },
            "gear5th": {
                "name": "5th gear",
                "value": -1.0
            },
            "gear6th": {
                "name": "6th gear",
                "value": -1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": -1.0
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_1999_oldsmobile_aurora_7802"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Oldsmobile"
            },
            "type": {
                "name": "Car type",
                "value": "Aurora V8"
            },
            "year": {
                "name": "Year",
                "value": 1999
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": 4
            },
            "body": {
                "name": "Body type",
                "value": "Sedan"
            },
            "seats": {
                "name": "Seats",
                "value": 5
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "FWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "Gas"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "N/A"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 70
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 4000
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 186
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 250
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 352
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": -1
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": 7.63
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1770
            },
            "length": {
                "name": "Length (mm)",
                "value": 5207
            },
            "width": {
                "name": "Width (mm)",
                "value": 1879
            },
            "height": {
                "name": "Height (mm)",
                "value": 1397
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": 127
            },
            "abs": {
                "name": "ABS",
                "value": "yes"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "N/A"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/1999_oldsmobile_aurora_7802.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "N/A"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.carspecs.us/cars/1999/oldsmobile/aurora/7802"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": 2.96
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": 1.63
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": 1.0
            },
            "gear4th": {
                "name": "4th gear",
                "value": 0.68
            },
            "gear5th": {
                "name": "5th gear",
                "value": -1.0
            },
            "gear6th": {
                "name": "6th gear",
                "value": -1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": 3.48
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_2015_bentley_continental-gt3-r_44722"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Bentley"
            },
            "type": {
                "name": "Car type",
                "value": "Continental GT3-R V8 Twin turbo"
            },
            "year": {
                "name": "Year",
                "value": 2015
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": -1
            },
            "body": {
                "name": "Body type",
                "value": "Coupe"
            },
            "seats": {
                "name": "Seats",
                "value": -1
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "4WD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "Gas"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "N/A"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 90
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": 4000
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 426
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 572
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": 702
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": -1
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": 4.27
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 2194
            },
            "length": {
                "name": "Length (mm)",
                "value": 4800
            },
            "width": {
                "name": "Width (mm)",
                "value": 1930
            },
            "height": {
                "name": "Height (mm)",
                "value": 1397
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": -25
            },
            "abs": {
                "name": "ABS",
                "value": "N/A"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "yes"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/2015_bentley_continental-gt3-r_44722.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "N/A"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.carspecs.us/cars/2015/bentley/continental-gt3-r/44722"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": -1.0
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": -1.0
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": -1.0
            },
            "gear4th": {
                "name": "4th gear",
                "value": -1.0
            },
            "gear5th": {
                "name": "5th gear",
                "value": -1.0
            },
            "gear6th": {
                "name": "6th gear",
                "value": -1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": -1.0
            }
        },
        {
            "id": {
                "name": "ID",
                "value": "c_2003_aston-martin_db7-vantage_12032"
            },
            "manufacturer": {
                "name": "Manufacturer",
                "value": "Aston Martin"
            },
            "type": {
                "name": "Car type",
                "value": "DB7 Vantage Volante"
            },
            "year": {
                "name": "Year",
                "value": 2003
            },
            "country": {
                "name": "Country",
                "value": "N/A"
            },
            "doors": {
                "name": "Doors",
                "value": -1
            },
            "body": {
                "name": "Body type",
                "value": "Convertible"
            },
            "seats": {
                "name": "Seats",
                "value": -1
            },
            "driveWheel": {
                "name": "Drive wheel",
                "value": "RWD"
            },
            "engineType": {
                "name": "Engine type",
                "value": "N/A"
            },
            "fuelType": {
                "name": "Fuel type",
                "value": "N/A"
            },
            "fuelTankCapacity": {
                "name": "Fuel tank (lit.)",
                "value": 81
            },
            "engineCapacity": {
                "name": "Engine capacity (cm<sup>3</sup>)",
                "value": -1000
            },
            "powerKW": {
                "name": "Power (KW)",
                "value": 313
            },
            "powerHP": {
                "name": "Power (HP)",
                "value": 420
            },
            "maxTorque": {
                "name": "Max Torque (Nm)",
                "value": -1
            },
            "topSpeed": {
                "name": "Top speed (km/h)",
                "value": -1
            },
            "acceleration": {
                "name": "0-100 km/h (sec)",
                "value": 4.62
            },
            "weight": {
                "name": "Weight (kg)",
                "value": 1860
            },
            "length": {
                "name": "Length (mm)",
                "value": -25
            },
            "width": {
                "name": "Width (mm)",
                "value": -25
            },
            "height": {
                "name": "Height (mm)",
                "value": -25
            },
            "groundClearance": {
                "name": "Ground clearence (mm)",
                "value": -25
            },
            "abs": {
                "name": "ABS",
                "value": "N/A"
            },
            "tractionControl": {
                "name": "Traction control",
                "value": "N/A"
            },
            "imageUrl": {
                "name": "Car image URL",
                "value": "assets/img/cars/2003_aston-martin_db7-vantage_12032.webp"
            },
            "logoURL": {
                "name": "Manufacturer Logo URL",
                "value": "N/A"
            },
            "carPageUrl": {
                "name": "Car page Url",
                "value": "https://www.carspecs.us/cars/2003/aston-martin/db7-vantage/12032"
            },
            "objectPositionHorizontal": {
                "name": "Object horizontal position",
                "value": "0vh"
            },
            "objectPositionVertical": {
                "name": "Object vertical position",
                "value": "0vh"
            },
            "objectWidth": {
                "name": "Object width",
                "value": "100%"
            },
            "objectHeight": {
                "name": "Object height",
                "value": "100%"
            },
            "gear1st": {
                "name": "1st gear",
                "value": -1.0
            },
            "gear2nd": {
                "name": "2nd gear",
                "value": -1.0
            },
            "gear3rd": {
                "name": "3rd gear",
                "value": -1.0
            },
            "gear4th": {
                "name": "4th gear",
                "value": -1.0
            },
            "gear5th": {
                "name": "5th gear",
                "value": -1.0
            },
            "gear6th": {
                "name": "6th gear",
                "value": -1.0
            },
            "finalDrive": {
                "name": "Final drive",
                "value": -1.0
            }
        }
    ];*/
    cardList: any;
    constructor(
        private eventService: EventService,
        private http: HttpClient
    ) {
    }

    ngOnInit(): void {

        this.getAllCard().subscribe(
            list => this.cardList = list,
            err => console.error(err),
            () => console.log('Unsubscribed')
        );
    }


    getAllCard() {

        let url = 'http://localhost:8080/api/cards';

        return this.http.get(url);
        // erre még rá kell nézni
        /*const response = fetch(
            url,
        {
            headers: {
                'Content-Type': 'application/json',
            },
            method: 'GET',
            mode: "no-cors"
            }
        );
        console.log('response')
        console.log(response)*/

    }

}

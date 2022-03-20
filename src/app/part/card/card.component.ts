import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {addWarning} from "@angular-devkit/build-angular/src/utils/webpack-diagnostics";
let flowtype = require('../../../assets/vendor/flowtype');

@Component({
    selector: 'app-card',
    templateUrl: './card.component.html',
    styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

    private url = "http://localhost:4200/api/cards";
    @Input() card: any;


    constructor() {
    }

    public flipToFront(givenId: any) {
        let card = document.querySelector(`#${givenId}`)!;
        card.classList.remove('flipCard');
        //console.log(card.id);
    }

    ngOnInit(): void {


    }

    sendCard(id: string, event: Event) {
        console.log(id);
        event.stopPropagation();
    }

   frontDatas() {

        return [
            this.card.acceleration,
            this.card.topSpeed,
            this.card.engineCapacity,
            this.card.driveWheel
        ];
    }

    chassisTabDatas() {

        return [
            this.card.acceleration,
            this.card.topSpeed,
            this.card.engineCapacity,
            this.card.maxTorque,
            this.card.weight,
            this.card.fuelTankCapacity
        ];
    }

    driveTabDatas() {

        return [
            this.card.driveWheel,
            this.card.engineType,
            this.card.fuelType,
            this.card.abs,
            this.card.tractionControl
        ];
    }

    dimensionTabDatas() {

        return [
            this.card.body,
            this.card.doors,
            this.card.seats,
            this.card.length,
            this.card.width,
            this.card.height,
            this.card.groundClearance
        ];
    }

    transmissionTabData() {

        return [
            this.card.gear1st,
            this.card.gear2nd,
            this.card.gear3rd,
            this.card.gear4th,
            this.card.gear5th,
            this.card.gear6th,
            this.card.finalDrive
        ];
    }

    ngOnChanges() {
//        console.log('data', this.cardValue);
    }





    async fetchAllCard() {

        const response = await fetch(this.url);
        const jsonData = await response.json();
        console.log(jsonData);
    }

}

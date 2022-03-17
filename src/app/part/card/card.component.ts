import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {addWarning} from "@angular-devkit/build-angular/src/utils/webpack-diagnostics";

@Component({
    selector: 'app-card',
    templateUrl: './card.component.html',
    styleUrls: ['./card.component.css'],
    //inputs: ['cardValue']
})
export class CardComponent implements OnInit {

    private url = "http://localhost:4200/api/cards";
    @Input() card: any;


    constructor() {
    }

    public flipToFront(givenId: any) {
        let card = document.querySelector(`#${givenId}`)!;
        card.classList.remove('flipCard');
        console.log(card.id)
    }

    ngOnInit(): void {

        //this.fetchAllCard();
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

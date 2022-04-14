import {Component, OnChanges, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {EventService} from "../event.service";
import {Event} from "@angular/router";

@Component({
    selector: 'app-deck',
    templateUrl: './deck.component.html',
    styleUrls: ['./deck.component.css']
})
export class DeckComponent implements OnInit, OnChanges {

    showPopup = false;
    cardList: any;
    popupCard: any;

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

        this.eventService.childEventListener().subscribe(card => {

            this.showPopup = !this.showPopup;
            this.popupCard = card;
        });
    }

    ngOnChanges() {

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

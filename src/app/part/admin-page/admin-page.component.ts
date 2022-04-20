import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {CardModel} from "../../part/card/card.model";
import {EventService} from "../event.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {log} from "util";
import {CardMapper} from "../card/cardMapper";
import {environment} from "../../../environments/environment";

export type InitProps = {
    identifier: string,
    name: string,
    value: number | string,
}

@Component({
    selector: 'app-admin-page',
    templateUrl: './admin-page.component.html',
    styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit, OnChanges {

    cardDTO: CardModel = new CardModel();
    initProps!: InitProps[];
    cardList!: CardModel[];
    selectedCard: any;
    searchFieldsShow = false;
    toggleCheckField = false;
    url = environment.backendUrl;
    concatenatedFilename = 'all-card';

    constructor(
        private eventService: EventService,
        private http: HttpClient,
    ) {
    }

    ngOnInit(): void {

        this.eventService.childEventListener().subscribe(card => {

            this.selectedCard = card;
        });

        this.dataExtractor();
        this.selectedCard = new CardModel();
    }

    ngOnChanges() {
    }


    writeCardsToFile(cardList: CardModel[]) {

        let fileName: string;

        if (this.concatenatedFilename === '') {
            fileName = 'all-card.txt';
        } else {
            fileName = this.concatenatedFilename + '.txt';
        }

        const fileContent = this.createFileContent(cardList);
        const file = new Blob([fileContent], {type: "text/plain"});
        const link = document.createElement("a");
        link.href = URL.createObjectURL(file);
        link.download = fileName;
        link.click();
        link.remove();
    }


    createFileContent(cardList: CardModel[]): any {

        let cards: any[] = [];
        const mapper = new CardMapper();

        for (const cardModel of cardList) {
            cards.push(mapper.mapToCard(cardModel))
        }

        return JSON.stringify(cards);
    }


    findCards() {

        const selectButton = document.querySelector('#select-btn') as HTMLElement;
        const inputFields = document.querySelectorAll('[data-search]');
        let betweenValues = [];
        this.concatenatedFilename = '';

        for (const inputField of Array.from(inputFields)) {
            const attrName = inputField.getAttribute('data-search')!;
            const value = (inputField as HTMLInputElement).value.trim();

            if (value) {
                this.concatenatedFilename += '(' + attrName + '-' + value + ')';
            }

            if (value.includes('-')) {
                betweenValues.push({
                    name: attrName,
                    values: [value.match(/^\d+(\.\d+)?/)![0], value.match(/(\d+\.)?\d+$/)![0]]
                });
                (this.cardDTO as any)[attrName] = null;
            } else {
                (this.cardDTO as any)[attrName] = this.convertEmptyToNull(value);
            }
        }

        const selectedCheckFields = document.querySelectorAll('[data-check].active');
        let isNullFields = [];

        for (const checkField of Array.from(selectedCheckFields)) {
            const attrName = checkField.getAttribute('data-check')!;
            isNullFields.push(attrName);
        }

        const tupleQuery = JSON.stringify({card: this.cardDTO, checks: isNullFields, betweens: betweenValues});
        const result = this.fetchCards(tupleQuery);

        return result;
    }


    updateCardList(json: CardModel[]) {

        this.cardList = json;
    }


    fetchCards(params: any) {

        const result = async () => {
            const response = await fetch(this.url + '/find', {
                method: "POST",
                body: params,
                headers: {
                    "Content-Type": "application/json"
                }
            });
            const jsonResponse = await response.json();
            this.updateCardList(jsonResponse);

            return jsonResponse;
        };

        return result();
    }


    convertEmptyToNull(param: string) {

        if (param) {
            return param;
        }

        return null;
    }


    createCard() {

        const createdCard = new CardMapper().mapToCard(this.selectedCard);

        fetch(this.url, {
            method: "POST",
            body: createdCard,
            headers: {
                "Content-Type": "application/json"
            }
        });
    }


    updateCard() {

        const updatedCard = new CardMapper().mapToCard(this.selectedCard);

        fetch(this.url, {
            method: "PUT",
            body: updatedCard,
            headers: {
                "Content-Type": "application/json"
            }
        });
    }


    getAllCard() {

        return this.http.get(this.url);
    }


    toggleSearchFields() {

        this.searchFieldsShow = !this.searchFieldsShow;
    }


    toggleCheckFields() {

        this.toggleCheckField = !this.toggleCheckField;
    }


    dataExtractor() {

        const props = Object.entries(this.cardDTO);
        this.initProps = [];
        for (const prop of props.values()) {

            const [identifier, dataObject] = prop;

            this.initProps.push({
                identifier: identifier,
                name: dataObject.name,
                value: dataObject.value
            });
        }
    }
}

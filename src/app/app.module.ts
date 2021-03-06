import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { CardComponent } from './part/card/card.component';
import { DeckComponent } from './part/deck/deck.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { TabContentComponent } from './part/card/tab-content/tab-content.component';
import { TextVarSizeBlockComponent } from './part/card/text-var-size-block/text-var-size-block.component';
import { AdminPageComponent } from './part/admin-page/admin-page.component';
import { SelectButtonComponent } from './part/card/select-button/select-button.component';
import { InputFieldComponent } from './part/admin-page/input-field/input-field.component';
import { CheckFieldComponent } from './part/admin-page/check-field/check-field.component';
import { CardPreviewComponent } from './part/admin-page/card-preview/card-preview.component';
import { CardListComponent } from './part/admin-page/card-list/card-list.component';
import { CardListItemComponent } from './part/admin-page/card-list/card-list-item/card-list-item.component';
import {EventService} from "./part/event.service";
import { SearchFieldsComponent } from './part/admin-page/search-fields/search-fields.component';
import { FightTableComponent } from './part/fight-table/fight-table.component';
import { PopupImgComponent } from './part/card/popup-img/popup-img.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialogModule} from "@angular/material/dialog";
import { PopupButtonComponent } from './part/card/popup-button/popup-button.component';
import { LockedImgComponent } from './part/card/locked-img/locked-img.component';



@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    DeckComponent,
    TabContentComponent,
    TextVarSizeBlockComponent,
    AdminPageComponent,
    SelectButtonComponent,
    InputFieldComponent,
    CheckFieldComponent,
    CardPreviewComponent,
    CardListComponent,
    CardListItemComponent,
    SearchFieldsComponent,
    FightTableComponent,
    PopupImgComponent,
    PopupButtonComponent,
    LockedImgComponent,
  ],
  imports: [
    BrowserModule,
      ReactiveFormsModule,
      HttpClientModule,
      FormsModule,
      NoopAnimationsModule,
      MatDialogModule,
  ],
  providers: [EventService],
  bootstrap: [AppComponent]
})
export class AppModule { }

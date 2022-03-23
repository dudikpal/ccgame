import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CardComponent } from './part/card/card.component';
import { DeckComponent } from './part/deck/deck.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { TabContentComponent } from './part/card/tab-content/tab-content.component';
import { TextVarSizeBlockComponent } from './part/card/text-var-size-block/text-var-size-block.component';
import { AdminPageComponent } from './part/admin-page/admin-page.component';
import { SelectButtonComponent } from './part/card/select-button/select-button.component';
import { InputFieldComponent } from './part/admin-page/input-field/input-field.component';
import { CheckFieldComponent } from './part/admin-page/check-field/check-field.component';


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
    CheckFieldComponent
  ],
  imports: [
    BrowserModule,
      ReactiveFormsModule,
      HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

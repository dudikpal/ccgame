import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CardComponent } from './part/card/card.component';
import { DeckComponent } from './part/deck/deck.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { TabContentComponent } from './part/tab-content/tab-content.component';
import { FontSizeVariableComponent } from './part/font-size-variable/font-size-variable.component';
import { TextVarSizeBlockComponent } from './part/text-var-size-block/text-var-size-block.component';


@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    DeckComponent,
    TabContentComponent,
    FontSizeVariableComponent,
    TextVarSizeBlockComponent
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

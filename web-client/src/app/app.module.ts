import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';

import {BoardGameService} from './board-game.service';
import {HttpClientModule} from '@angular/common/http';
import {BoardGameListComponent} from './board-game-list/board-game-list.component';

import {MatNativeDateModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AllMaterialModule} from './material-module';

@NgModule({
  declarations: [
    AppComponent,
    BoardGameListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AllMaterialModule,
    MatNativeDateModule
  ],
  providers: [BoardGameService],
  bootstrap: [AppComponent]
})
export class AppModule { }

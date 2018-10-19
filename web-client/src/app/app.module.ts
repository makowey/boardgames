import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { BoardGameService } from './board-game.service';
import { HttpClientModule } from '@angular/common/http';
import { BoardGameListComponent } from './board-game-list/board-game-list.component';

import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {DemoMaterialModule} from './material-module';

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
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    DemoMaterialModule
  ],
  providers: [BoardGameService],
  bootstrap: [AppComponent]
})
export class AppModule { }

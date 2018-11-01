import {Component, OnInit} from '@angular/core';
import {BoardGameService} from "./board-game.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Boardgames share market';
  boardGame: any;

  constructor(private boardGameService: BoardGameService) {
  }

  ngOnInit() {
    this.boardGameService.getOne().subscribe(data => {
      this.boardGame = data;
    });
  }
}

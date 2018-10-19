import {Component, OnInit} from '@angular/core';
import {BoardGameService} from "../board-game.service";

@Component({
  selector: 'app-board-game-list',
  templateUrl: './board-game-list.component.html',
  styleUrls: ['./board-game-list.component.css']
})
export class BoardGameListComponent implements OnInit {
  boardGames: Array<any>;

  constructor(private boardGameService: BoardGameService) {
  }

  ngOnInit() {
    this.boardGameService.getAll().subscribe(data =>
      this.boardGames = data
    )
  }

}

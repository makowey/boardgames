import {Component, OnInit, ViewChild} from '@angular/core';
import {BoardGameService} from "../board-game.service";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-board-game-list',
  templateUrl: './board-game-list.component.html',
  styleUrls: ['./board-game-list.component.css']
})
export class BoardGameListComponent implements OnInit {
  boardGames;
  displayedColumns: string[] = ['prod', 'name', 'price', 'store'];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private boardGameService: BoardGameService) {
  }

  ngOnInit() {
    this.boardGameService.getAll().subscribe(data => {
      this.boardGames = new MatTableDataSource<BoardGame>(data);
      this.boardGames.paginator = this.paginator;
      this.boardGames.sort = this.sort;
    });
  }

  applyFilter(filterValue: string) {
    this.boardGames.filter = filterValue.trim().toLowerCase();
  }
}

export interface BoardGame {
  name: string;
  urlImage: string;
  price: number;
  store: string;
}

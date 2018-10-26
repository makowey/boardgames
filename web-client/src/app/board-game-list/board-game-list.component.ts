import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {BoardGameService} from "../board-game.service";
import {MatPaginator, MatSort, MatSortable, MatTableDataSource} from "@angular/material";
import {tap} from "rxjs/operators";

@Component({
  selector: 'app-board-game-list',
  templateUrl: './board-game-list.component.html',
  styleUrls: ['./board-game-list.component.css']
})
export class BoardGameListComponent implements OnInit, AfterViewInit {
  boardGames;
  originalData;
  displayedColumns: string[] = ['prod', 'name', 'currentPrice', 'store'];
  numberOfGames;

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private boardGameService: BoardGameService) {
  }

  ngOnInit() {
    this.boardGameService.getAll().subscribe(data => {
      this.originalData = data;
      this.refresh(data);
    });
  }

  ngAfterViewInit() {
    this.paginator.page
      .pipe(
        tap(() => this.boardGameService.findBoardGames(0, this.boardGames.filter))
      )
      .subscribe();
  }

  applyFilter(filterValue: string) {
    this.boardGames.filter = filterValue.trim().toLowerCase();
  }

  findBoardGame(filterValue: string) {
    this.boardGames.filter = filterValue.replace(/ /g, "%20");
    this.boardGameService.findBoardGames(0, this.boardGames.filter)
      .subscribe(data => {
        this.originalData = this.originalData.concat(data);
        this.refresh(data);
      });
  }

  refresh(data) {
    this.boardGames = new MatTableDataSource<BoardGame>(data);
    this.boardGames.paginator = this.paginator;
    this.sort.sort(<MatSortable>({id: 'currentPrice', start: 'asc'}));
    this.boardGames.sort = this.sort;
    this.numberOfGames = data.length;
  }
}

export interface BoardGame {
  name: string;
  urlImage: string;
  currentPrice: number;
  store: string;
}

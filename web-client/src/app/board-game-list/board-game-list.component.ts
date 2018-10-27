import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {BoardGameService} from "../board-game.service";
import {MatPaginator, MatSort, MatSortable, MatTableDataSource} from "@angular/material";
import {tap} from "rxjs/operators";
import {Observable} from "rxjs";
import 'rxjs/add/observable/of';

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

    this.boardGameService.count().subscribe(data => {
      this.numberOfGames = data;
    });
  }

  ngAfterViewInit() {
    this.paginator.page
      .pipe(
        tap(() => this.boardGameService.search(Observable.of(this.boardGames.filter)))
      )
      .subscribe();
  }

  applyFilter(filterValue: string) {
    this.boardGames.filter = filterValue.trim().toLowerCase();

    if (this.boardGames.filter.length > 3) {
      this.boardGameService.search(Observable.of(this.boardGames.filter))
        .subscribe(data => {
          this.refresh(data);
        });
    }
  }

  findBoardGame(filterValue: string) {
    this.boardGames.filter = filterValue.replace(/ /g, "%20");
    this.boardGameService.findAndUpdateBoardGames(0, this.boardGames.filter)
      .subscribe(data => {
        this.refresh(data);
      });
  }

  refresh(data) {
    this.boardGames = new MatTableDataSource<BoardGame>(data);
    this.boardGames.paginator = this.paginator;
    this.sort.sort(<MatSortable>({id: 'currentPrice', start: 'asc'}));
    this.boardGames.sort = this.sort;
  }
}

export interface BoardGame {
  name: string;
  urlImage: string;
  currentPrice: number;
  store: string;
}

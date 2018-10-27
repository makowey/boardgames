import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {BoardGameService} from "../board-game.service";
import {MatPaginator, MatSort, MatSortable, MatTableDataSource} from "@angular/material";
import {tap} from "rxjs/operators";
import {Observable} from "rxjs";
import 'rxjs/add/observable/of';
import {FormControl} from "@angular/forms";

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
  stateCtrl = new FormControl();
  isGeekMarket;

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private boardGameService: BoardGameService) {
    this.isGeekMarket = this.stateCtrl.disable;
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
        tap(() => this.boardGameService.search(
          Observable.of(this.boardGames.filter),
          this.isGeekMarket))
      )
      .subscribe();
  }

  applyFilter(filterValue: string) {
    this.boardGames.filter = filterValue.trim().toLowerCase();
    this.isGeekMarket = this.stateCtrl.disabled;

    if (this.boardGames.filter.length > 1) {
      this.boardGameService.search(
        Observable.of(this.boardGames.filter),
        this.isGeekMarket)
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

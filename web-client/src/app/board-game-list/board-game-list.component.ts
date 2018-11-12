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
  numberOfBggCollection = 0;
  totalBggCollection = 0;
  stateCtrl = new FormControl();
  isGeekMarket;
  currentFilter = "#20";

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  private isLoading: boolean = true;

  constructor(private boardGameService: BoardGameService) {
    this.isGeekMarket = false;
    this.stateCtrl.disable();
  }

  ngOnInit() {
    this.boardGameService.getAll().subscribe(data => {
        this.originalData = data;
        this.refresh(data);
      },
      () => this.isLoading = false);

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
    this.currentFilter = filterValue;
    this.boardGames.filter = filterValue.trim().toLowerCase();

    if (this.currentFilter.startsWith("#")) return this.blackFriday(filterValue);

    if (this.currentFilter.startsWith("@") &&
      this.currentFilter.endsWith("@")) {
      this.isLoading = true;

      this.boardGameService.findCollections(this.boardGames.filter)
        .subscribe(data => {
          this.totalBggCollection = this.getTotal(data);
          this.numberOfBggCollection = data.length;
          this.refresh(data);
          },
          () => this.isLoading = false);
      return;
    }

    if(this.currentFilter.startsWith("@")) return;

    if (this.boardGames.filter.length > 1) {
      this.isLoading = true;

      this.boardGameService.search(
        Observable.of(this.boardGames.filter),
        this.isGeekMarket)
        .subscribe(data => {
          this.numberOfBggCollection = 0;
          this.refresh(data);
          },
          () => this.isLoading = false);
    }
  }

  findBoardGame(filterValue: string) {
    this.currentFilter = filterValue;
    if (this.currentFilter.startsWith("@") ||
      this.currentFilter.startsWith("#")) return;

    this.isLoading = true;
    this.boardGames.filter = filterValue.replace(/ /g, "%20");
    this.boardGameService.findAndUpdateBoardGames(0, this.boardGames.filter)
      .subscribe(data => {
        this.refresh(data);
        },
        () => this.isLoading = false);
  }

  blackFriday(filterValue: string) {
    this.currentFilter = filterValue.replace("#", "");

    this.isLoading = true;
    this.boardGames.filter = this.currentFilter;
    this.boardGameService.blackFriday(this.boardGames.filter)
      .subscribe(data => {
          this.refresh(data);
        },
        () => this.isLoading = false);
  }

  refresh(data) {
    this.boardGames = new MatTableDataSource<BoardGame>(data);
    this.boardGames.paginator = this.paginator;
    this.sort.sort(<MatSortable>({id: 'currentPrice', start: 'asc'}));
    this.boardGames.sort = this.sort;
    this.isLoading = false;
  }

  enableGeekMarket() {
    this.stateCtrl.enable();
    this.isGeekMarket = true;
    this.applyFilter(this.currentFilter);
  }

  disableGeekMarket() {
    this.stateCtrl.disable();
    this.isGeekMarket = false;
    this.applyFilter(this.currentFilter);
  }

  onChange() {
    this.stateCtrl.disabled ?
      this.enableGeekMarket() :
      this.disableGeekMarket();
  }

  getTotal(data) {
    let total = 0;
    data.forEach(game => total += game.currentPrice);
    return total;
  }
}

export interface BoardGame {
  name: string;
  urlImage: string;
  currentPrice: number;
  bestPrice: number;
  store: string;
  percent: number;
}

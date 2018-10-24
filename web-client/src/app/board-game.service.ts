import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {map} from "rxjs/operators";
import {BoardGame} from "./board-game-list/board-game-list.component";

@Injectable({
  providedIn: 'root'
})
export class BoardGameService {

  baseUrl = "//localhost:8083";

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.baseUrl + '/all');
  }

  findBoardGames(
    gameId: number, name = ''): Observable<BoardGame[]> {

    return this.http.get(this.baseUrl + '/search', {
      params: new HttpParams()
        .set('gameId', gameId.toString())
        .set('name', name)
        .set('extractor', 'REGAT')
    }).pipe(
      map(res => res["payload"])
    );
  }
}

import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

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
    gameId: number, name = ''): Observable<any> {

    return this.http.get(this.baseUrl + '/search', {
      params: new HttpParams()
        .set('gameId', gameId.toString())
        .set('name', name)
    });
  }
}

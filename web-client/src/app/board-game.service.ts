import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';

@Injectable({
  providedIn: 'root'
})
export class BoardGameService {

  baseUrl = "";//localhost:8083";

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.baseUrl + '/all');
  }

  count(): Observable<any> {
    return this.http.get(this.baseUrl + '/count');
  }

  private findBoardGames(name = ''): Observable<any> {
    return this.http.get(this.baseUrl + '/find', {
      params: new HttpParams()
        .set('name', name)
    });
  }

  findAndUpdateBoardGames(
    gameId: number, name = ''): Observable<any> {

    return this.http.get(this.baseUrl + '/search', {
      params: new HttpParams()
        .set('gameId', gameId.toString())
        .set('name', name)
    });
  }

  search(term: Observable<string>): Observable<any> {
    return term
      .debounceTime(1000)
      .distinctUntilChanged()
      .switchMap(term => this.findBoardGames(term));
  }
}

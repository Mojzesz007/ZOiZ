import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../shared/models/user.types';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private _http: HttpClient) { }

  public login(login: string, pass: string): Observable<User> {
    return this._http.get<User>(`${environment.api.url}/users/login?login=${login}&password=${pass}`);
  }
}

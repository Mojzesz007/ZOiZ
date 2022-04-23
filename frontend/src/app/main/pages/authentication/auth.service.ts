import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'app/models/user.types';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor(private _http: HttpClient) { }

  public login(login: string, pass: string): Observable<User> {
    return this._http.get<User>(`${environment.api.url}/users/login?login=${login}&password=${pass}`);
  }

  public register(user: User) {
    return this._http.post<User>(`${environment.api.url}/users/add`, user);
}
}

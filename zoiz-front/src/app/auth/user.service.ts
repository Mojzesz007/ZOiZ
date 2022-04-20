import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  public login(login: string, pass: string): Observable<boolean> {
    return of((login === 'admin' && pass === 'admin'))
  }
}

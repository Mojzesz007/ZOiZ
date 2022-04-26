import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Activity } from 'app/models/activity.types';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ActivityService {

  constructor(private http: HttpClient) { }

  getActivities(): Observable<Activity[]> {
    return this.http
    .get<Activity[]>(
      `${environment.api.url}/activities/all`);
  }
}

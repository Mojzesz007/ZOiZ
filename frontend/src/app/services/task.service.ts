import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task } from 'app/models/task.types';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) { }

  getAllTasks(): Observable<Task[]> {
    return this.http
    .get<Task[]>(`${environment.api.url}/tasks/all`);
  }
}

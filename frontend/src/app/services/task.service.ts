import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Task } from 'app/models/task.types';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';
import {User} from "../models/user.types";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) { }

  getAllTasks(): Observable<Task[]> {
    return this.http
    .get<Task[]>(`${environment.api.url}/tasks/all`);
  }

  getUserTasks(id: number): Observable<Task[]> {
      return this.http
          .get<Task[]>(`${environment.api.url}/tasks/user/${id}`)
  }

  updateTask(task: Task) {
        return this.http.put<Task>(`${environment.api.url}/tasks/update`, task);
    }

  deleteTask(id: number) {
      return this.http.delete(`${environment.api.url}/tasks/delete/${id}`)
    }
}

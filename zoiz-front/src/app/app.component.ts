import { Component, Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  message$!: Observable<string>;

  constructor(private _appService: AppService) {}

  ngOnInit(): void {
    this.message$ = this._appService.getHello();
    
  }
}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  
  loginForm = new FormGroup({
    login: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  })
  loginFailed: boolean = false;

  constructor(
    private _userService: UserService,
    private _router: Router,
  ) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
console.log(this.loginForm.value);

    this._userService
    .login(
      this.loginForm.value['login'],
      this.loginForm.value['password']
      ).subscribe({
        next: result => {
          if (result) {
            localStorage.setItem('user', 'logged');
            this.loginFailed = false;
            this._router.navigate(['/dashboard']);
          } else {
            this.loginFailed = true;
          }
        }
      })

  }

}

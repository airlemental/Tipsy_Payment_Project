import { Component, OnInit } from '@angular/core';
import {AppService} from 'src/app/app.service';

@Component({
  selector: 'login-form',
  providers: [AppService],
  template: `
    <div class="col-sm-6">
        <h1>Login</h1>
        <div class="col-sm-12 form-group">
             <label>Username</label>
             <input class="form-control" type="text" [(ngModel)]="loginData.username" />
        </div>
        <div class="col-sm-12 form-group">
            <label>Password</label>
            <input class="form-control" type="password"  [(ngModel)]="loginData.password"/>
        </div>
        <div class="col-sm-12">
            <button class="btn btn-primary pull-right" (click)="login()" type="submit">Login</button>
        </div>
    </div>`
})
export class LoginComponent implements OnInit {

  public loginData = {username: "", password: ""};

  constructor(private _service:AppService) {}

  ngOnInit() {
  }

  login() {
    this._service.obtainAccessToken(this.loginData);
  }

}

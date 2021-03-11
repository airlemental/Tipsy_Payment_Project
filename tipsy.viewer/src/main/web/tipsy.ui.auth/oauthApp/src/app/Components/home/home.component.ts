import {Component, OnInit } from '@angular/core';
import {AppService} from 'src/app/app.service';



@Component({
  selector: 'home-header',
  providers: [AppService],
  template: `<span>Welcome !!</span>
    <a (click)="logout()" href="#">Logout</a>
    <foo-details></foo-details>`
})

// @Component({
//   selector: 'home-header',
//   providers: [AppService],
//   template: `<div class="container" >
//     <button *ngIf="!isLoggedIn" class="btn btn-primary" (click)="login()" type="submit">Login</button>
//     <div *ngIf="isLoggedIn" class="content">
//         <span>Welcome !!</span>
//         <a class="btn btn-default pull-right"(click)="logout()" href="#">Logout</a>
//         <br/>
//         <foo-details></foo-details>
//     </div>
// </div>`
// })

export class HomeComponent implements OnInit{
  // public isLoggedIn = false;

  constructor(
    private _service:AppService){}


  ngOnInit(){
    this._service.checkCredentials();
  }

  // ngOnInit(){
  //   this.isLoggedIn = this._service.checkCredentials();
  //   let i = window.location.href.indexOf('code');
  //   if(!this.isLoggedIn && i != -1){
  //     this._service.retrieveToken(window.location.href.substring(i + 5));
  //   }
  // }


  // login() {
  //   window.location.href = 'http://localhost:8081/tipsy-security/oauth/authorize?response_type=code&client_id=' + this._service.clientId + '&redirect_uri='+ this._service.redirectUri;
  // }

  logout() {
    this._service.logout();
  }
}
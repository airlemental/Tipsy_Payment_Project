import {Injectable} from '@angular/core';

import { Cookie } from 'js.cookie';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
// import 'rxjs/add/operator/catch';
// import 'rxjs/add/operator/map';
import {catchError} from 'rxjs/operators';
// import * as Http from "http";
import {Router} from "@angular/router";

export class Foo {
  constructor(
    public id: number,
    public name: string) { }
}


@Injectable()
export class AppService {
  constructor(
    private _router: Router, private _http: HttpClient){}

  obtainAccessToken(loginData){
    let params = new URLSearchParams();
    params.append('username', loginData.username);
    params.append('password', loginData.password);
    params.append('grant_type','password');
    params.append('client_id','Wind');

    const headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Basic '+ btoa("Wind:secret")});
    // let options = new RequestOptions({ headers: headers });
    console.log(params.toString());
    this._http.post('http://localhost:8081/tipsy-security/oauth/token', params.toString(), { headers })
      // .map(res => res.json())
      .subscribe(
        data => this.saveToken(data),
        err => alert('Invalid Credentials')
      );
  }

  // @Injectable()
// export class AppService {
//   public clientId = 'fooClientIdPassword';
//   public redirectUri = 'http://localhost:8089/';
//
//   constructor(
//     // tslint:disable-next-line:variable-name
//     private _http: HttpClient) {}
//
//   retrieveToken(code) {
//     const params = new URLSearchParams();
//     params.append('grant_type', 'authorization_code');
//     params.append('client_id', this.clientId);
//     params.append('redirect_uri', this.redirectUri);
//     params.append('code', code);
//
//     const headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
//       Authorization: 'Basic ' + btoa(this.clientId + ':secret')});
//     this._http.post('http://localhost:8081/tipsy-security/oauth/token', params.toString(), { headers })
//       .subscribe(
//         data => this.saveToken(data),
//         err => alert('Invalid Credentials')
//       );
//   }


  saveToken(token){
    const expireDate = new Date().getTime() + (1000 * token.expires_in);
    Cookie.set("access_token", token.access_token, expireDate);
    console.log('Obtained Access token');
    this._router.navigate(['/']);
  }

  //
//   saveToken(token) {
//     const expireDate = new Date().getTime() + (1000 * token.expires_in);
//     Cookie.set('access_token', token.access_token, expireDate);
//     console.log('Obtained Access token');
//     window.location.href = 'http://localhost:8089';
//   }

  getResource(resourceUrl) : Observable<any>{
    const headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Bearer ' + Cookie.get('access_token')});
    return this._http.get(resourceUrl, { headers }).pipe(
    catchError((error: any) => Observable.throw(error.json().error || 'Server error')));
  }

  //
//   getResource(resourceUrl): Observable<any> {
//     const headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
//       Authorization: 'Bearer ' + Cookie.get('access_token')});

//     return this._http.get(resourceUrl, { headers }).pipe(
//     catchError((error: any) => Observable.throw(error.json().error || 'Server error')));
//   }

  checkCredentials(){
    if (!Cookie.check('access_token')){
      this._router.navigate(['/login']);
    }
  }

  //
//   checkCredentials() {
//     return Cookie.check('access_token');
//   }

  logout() {
    Cookie.delete('access_token');
    this._router.navigate(['/login']);
  }

  //
//   logout() {
//     Cookie.delete('access_token');
//     window.location.reload();
//   }

}








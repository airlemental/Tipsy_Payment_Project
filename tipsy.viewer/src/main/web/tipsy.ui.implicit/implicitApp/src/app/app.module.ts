import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { OAuthModule } from 'angular-oauth2-oidc';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FooComponent } from './foo/foo.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    OAuthModule.forRoot(),
    RouterModule.forRoot([
      { path: '', component: HomeComponent }])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

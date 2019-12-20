import { Component, OnInit } from '@angular/core';
import {AppService, Foo} from '../../app.service';


@Component({
  // tslint:disable-next-line:component-selector
  selector: 'foo-details',
  providers: [AppService],
  template: `<div class="container">
    <h1 class="col-sm-12">Foo Details</h1>
    <div class="col-sm-12">
        <label class="col-sm-3">ID</label> <span>{{foo.id}}</span>
    </div>
    <div class="col-sm-12">
        <label class="col-sm-3">Name</label> <span>{{foo.name}}</span>
    </div>
    <div class="col-sm-12">
        <button class="btn btn-primary" (click)="getFoo()" type="submit">New Foo</button>
    </div>
</div>`
})

export class FooComponent {
  public foo = new Foo(1, 'sample foo');
  private foosUrl = 'http://localhost:8082/tipsy-viewer/foos/';

  // tslint:disable-next-line:variable-name
  constructor(private _service: AppService) {}

  getFoo() {
    this._service.getResource(this.foosUrl + this.foo.id)
      .subscribe(
        data => this.foo = data,
        error =>  this.foo.name = 'Error');
  }
}

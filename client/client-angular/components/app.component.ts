import{Component}from'@angular/core';
import {Http,Response}from '@angular/http'

@Component({
  selector: 'my-app',
  template: `<h1>Hello {{name}}</h1>
            <p>{{json}}</p>
  `,
})
export class AppComponent  { 
  name = 'Angular';
  json:any
  constructor(http:Http){
    
    http.get("http://localhost:8080").subscribe(
    data => this.json=data)
  
 }
}
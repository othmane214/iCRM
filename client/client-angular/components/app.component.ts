import{Component}from'@angular/core';
import {Http,Response}from '@angular/http'
import {Observable}from 'rxjs/Rx';
import {Personne}from '../modele/modele'

// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Component({
  selector: 'my-app',
  template: `<h1>Hello {{name}}</h1>
            <h2> Les personnes présentes sont : </h2>
            <ul>
              <li *ngFor="let p of personnes">je suis {{p.nom}} {{p.prenom}}, j'ai {{p.age}} et voici mon email : {{p.email}} </li>
            </ul>
  `,
})
export class AppComponent  { 
  name = 'Angular';
  personnes:Personne[]
  http:Http
  constructor(http:Http){
    this.http=http
    this.http.get("http://localhost:8080/").map(this.extractData).subscribe(data=>this.personnes=data)
                    
  
 }

 private extractData(res: Response) {
    let body = res.json();
    return <Personne[]>body.data || [];
  }

  private handleError (error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    }
}
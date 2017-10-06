import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/map';

/*
  Generated class for the JsonDataProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class JsonDataProvider {

    constructor(public http: Http) {
        console.log('Hello JsonDataProvider Provider');
    }
    
    getData() {
        let headers = new Headers();
        headers.append('Content-Type','application/json');
        
        let body = {
            "user":"cris",
            "token":"cris:42d4f17d7b7f0e7"
        };
        
        this.http.post('http://localhost:8088/MYUNIVAQ3/rest/236425', JSON.stringify(body), {headers: headers})
            .subscribe(data => {
                console.log(data);
            });
    }

}
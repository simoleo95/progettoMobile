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
    
    getData(utente) {
        return new Promise(resolve => {
    
            let headers = new Headers();
            headers.append('Content-Type','application/json');

            let body = {
                "user": utente.user,
                "token": utente.token
            };
            
            this.http.post('http://localhost:8088/MYUNIVAQ3/rest/' + utente.matricola, JSON.stringify(body), {headers: headers})
                .map(res => res.json())
                .subscribe(data => {
                    resolve(data);
                });
        });
    }
    
    getUser(user, password) {
         return new Promise(resolve => {
            let headers = new Headers();
            headers.append('Content-Type','application/json');
             
             let body = {
                 "user":user,
                 "psw":password
             }
             
              this.http.post('http://localhost:8088/MYUNIVAQ3/rest/login', JSON.stringify(body), {headers: headers})
                 .map(res => res.json())
                 .subscribe(data => {
                     resolve(data);
                 });
         });
     }

}
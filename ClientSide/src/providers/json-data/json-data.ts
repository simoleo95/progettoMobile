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
    
    data: any;
    
    constructor(public http: Http) {
        console.log('Hello JsonDataProvider Provider');
    }
    
    getData(utente) {
        
        if(this.data) {
            return Promise.resolve(this.data);
        }
        
        return new Promise(resolve => {
    
            let headers = new Headers();
            headers.append('Content-Type','application/json');

            let body = {
                "user": utente.user,
                "token": utente.token
            };
            
            console.log("Body: " + body);
            console.log("Url: " + 'http://localhost:8088/MYUNIVAQ3/rest/' + utente.matricola)
            
            this.http.post('http://localhost:8088/MYUNIVAQ3/rest/' + utente.matricola, JSON.stringify(body), {headers: headers})
                .map(res => res.json())
                .subscribe(data => {
                    // console.log(data);
                    this.data = data;
                    resolve(this.data);
                });
        });
    }
    
    getUser(user, password) {
         if(this.data) {
             return Promise.resolve(this.data);
         }
         
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
                     console.log(JSON.stringify(body));
                     this.data = data;
                     resolve(this.data);
                 });
         });
     }

}
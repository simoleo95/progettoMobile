import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/map';

/*
  Generated class for the JsonDataProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
export class MyArray {
    domanda: string;
    risposta: string;
    
    constructor(domanda: string, risposta: string) {
        this.domanda = domanda;
        this.risposta = risposta;
    }
}

@Injectable()
export class JsonDataProvider {
    
    host: string = "localhost";
    
    constructor(public http: Http) {
        console.log('Hello JsonDataProvider Provider');
    }
    
    getData(utente, parametro = "") {
        return new Promise(resolve => {
    
            let headers = new Headers();
            headers.append('Content-Type','application/json');

            let body = {
                "user": utente.user,
                "token": utente.token
            };
            
            this.http.post('http://' + this.host +':8088/MYUNIVAQ3/rest/' + utente.matricola + '/' + parametro, JSON.stringify(body), {headers: headers})
                .map(res => res.json())
                .subscribe(data => {
                    resolve(data);
                });
        });
    }
    
    getQuestionario(utente, materia, prof) {
        return new Promise(resolve => {
           
            let headers = new Headers();
            headers.append('Content-Type','application/json');
            
            let body = {
              "studente": String(utente.matricola),
              "materia": materia,
              "prof": String(prof)
            };
            
            this.http.post('http://' + this.host + ':8088/MYUNIVAQ3/rest/generic/questionario', JSON.stringify(body), {headers: headers})
                .subscribe(data => {
                    resolve(data.text());
                });
        });
    }
    
    getGeneric(url) {
        return new Promise(resolve => {
           
            let headers = new Headers();
            headers.append('Content-Type','application/json');
            
            
            
            this.http.get("http://" + this.host + url.slice(16), {headers: headers})
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
             
              this.http.post('http://' + this.host + ':8088/MYUNIVAQ3/rest/login', JSON.stringify(body), {headers: headers})
                 .map(res => res.json())
                 .subscribe(data => {
                     resolve(data);
                 });
         });
     }
    
    putQuestionario(domande, risposte, utente, materia, prof) {
         return new Promise(resolve => {
            let headers = new Headers();
            headers.append('Content-Type','application/json');
            
             let result: Array<MyArray> = [];
             
            for (let entry in domande) {
                let temp = new MyArray(domande[entry]['question'], domande[entry]['answers'][risposte[entry]]);
                result.push(temp);
            }
             
             let body = {
              "studente": String(utente.matricola),
              "materia": materia,
              "prof": String(prof),
              "questionario": result
             };
             
             console.log(JSON.stringify(body));
             
              this.http.post('http://' + this.host + ':8088/MYUNIVAQ3/rest/generic/questionariosalva', JSON.stringify(body), {headers: headers})
                 .map(res => res.json())
                 .subscribe(data => {
                     resolve(data);
                 });
         });
    }

}
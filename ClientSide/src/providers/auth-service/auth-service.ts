import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import { JsonDataProvider } from '../../providers/json-data/json-data';

export class User {
  // Qui informazioni riguardanti lo studente
    
  user: string;
  matricola: number;
  token: string;
 
  constructor(user: string, matricola: number, token: string) {
    this.user = user;
    this.matricola = matricola;
    this.token = token;
  }
}

@Injectable()
export class AuthServiceProvider {
    
  currentUser: User;
  temp: any = null;
     
  constructor(public JsonService: JsonDataProvider) { }

  public login(credentials) {
    if (credentials.user === null || credentials.password === null) {
      return Observable.throw("Please insert credentials");
    } 
    else {
      return Observable.create(observer => {
          
        this.JsonService.getUser(credentials.user, credentials.password).then(data => {
            if(data != "psw errata")
                this.temp = data;
            
            let access = (this.temp["token"] !== "user inesistente ");
            
            // Cambiare dati con quelli veri
            this.currentUser = new User(this.temp['user'], this.temp['matricola'], this.temp['token']);
            observer.next(access);
            observer.complete();
        });
      });
    }
  }
 
  public getUserInfo() : User {
    return this.currentUser;
  }
 
  public logout() {
    return Observable.create(observer => {
      this.currentUser = null;
      observer.next(true);
      observer.complete();
    });
  }
}

import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import { JsonDataProvider } from '../../providers/json-data/json-data';

export class User {
  // Qui informazioni riguardanti lo studente
    
  name: string;
  email: string;
 
  constructor(name: string, email: string) {
    this.name = name;
    this.email = email;
  }
}

@Injectable()
export class AuthServiceProvider {
    
  currentUser: User;
  token: any = null;
     
  constructor(public JsonService: JsonDataProvider) { }

  public login(credentials) {
    if (credentials.user === null || credentials.password === null) {
      return Observable.throw("Please insert credentials");
    } else {
      return Observable.create(observer => {
        // At this point make a request to your backend to make a real check!
        this.JsonService.getUser(credentials.user, credentials.password).then(data => {
            if(data != "psw errata")
                this.token = data;
        });
         
        let access = (this.token !== null);
          
        // Cambiare dati con quelli veri
        this.currentUser = new User('Cristiano Orsetti', 'cristiano.orsetti@student.univaq.it');
        observer.next(access);
        observer.complete();
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

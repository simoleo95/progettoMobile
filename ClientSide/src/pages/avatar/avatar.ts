import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { LoginPage } from '../login/login'; 

import { AuthServiceProvider } from '../../providers/auth-service/auth-service';
import { JsonDataProvider } from '../../providers/json-data/json-data';
//
//export class Utente {
//    nome: string;
//    cognome: string;
//    matricola: number;
//    nascita: string;
//    
//    constructor(nome: string, cognome: string, matricola: number, nascita: string) {
//        this.nome = nome;
//        this.cognome = cognome;
//        this.matricola = matricola;
//        this.nascita = nascita;
//    }
//}

@Component({
  selector: 'page-avatar',
  templateUrl: 'avatar.html'
})

export class AvatarPage {
    
  nome: string = "";
  cognome: string = "";
  matricola: number;
  nascita: string = "";

  constructor(public nav: NavController, private auth: AuthServiceProvider, public JsonService: JsonDataProvider) {
      this.JsonService.getData(this.auth.getUserInfo()).then(data => {
          this.nome = data.nome;
          this.cognome = data.cognome;
          this.matricola = data.matricola;
          this.nascita = data.dataDiNascita;
      });
  }

  public logout() {
    this.auth.logout().subscribe(succ => {
      this.nav.setRoot(LoginPage)
    });
  }

}

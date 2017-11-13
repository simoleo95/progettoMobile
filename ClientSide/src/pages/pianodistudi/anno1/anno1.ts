import { Component } from '@angular/core';
import { IonicPage, NavController, App } from 'ionic-angular';

import { JsonDataProvider } from '../../../providers/json-data/json-data';
import { AuthServiceProvider } from '../../../providers/auth-service/auth-service';
import { NomemateriaPage } from '../../nomemateria/nomemateria';

@IonicPage()
@Component({
  selector: 'page-anno1',
  templateUrl: 'anno1.html',
})
export class Anno1Page {
    
  esami: Array<any> = [];

  constructor(public navCtrl: NavController, public appCtrl: App, public JsonService: JsonDataProvider, private auth: AuthServiceProvider) {
         this.JsonService.getData(this.auth.getUserInfo(), "tutti_i_corsi").then(data => {
           for (let entry in data) {
               if(data[entry].anno == "1") {
                   this.esami.push(data[entry]);   
               }
           }
       });
  }
    
  Navigate() {
      this.appCtrl.getRootNav().push(NomemateriaPage);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Anno1Page');
  }

}

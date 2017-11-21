import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';

import { AvatarPage } from '../avatar/avatar';
import { JsonDataProvider } from '../../providers/json-data/json-data';
import { AuthServiceProvider } from '../../providers/auth-service/auth-service';

/**
 * Generated class for the OrarioPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-orario',
  templateUrl: 'orario.html',
})
export class OrarioPage {
    
    giorno: string;
    orario: Array<any> = [];

  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App,
			   public JsonService: JsonDataProvider, private auth: AuthServiceProvider) {
      this.giorno = "lunedì";
      
      this.JsonService.getData(this.auth.getUserInfo(), "orario").then(data => {
         for (let entry in data) {
             data[entry].oraInizio = (data[entry].oraInizio).slice(0, -3);
             data[entry].oraFine = (data[entry].oraFine).slice(0, -3);
             this.orario.push(data[entry]);
         } 
      });
     
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad OrarioPage') ;
  }
    
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

}

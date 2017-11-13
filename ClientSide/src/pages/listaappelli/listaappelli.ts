import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { JsonDataProvider } from '../../providers/json-data/json-data';
import { AuthServiceProvider } from '../../providers/auth-service/auth-service';
import { DettaglioAppelliPage } from '../dettaglioappelli/dettaglioappelli';

/**
 * Generated class for the ListaAppelliPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-listaappelli',
  templateUrl: 'listaappelli.html',
})
export class ListaAppelliPage {

  appelli: Array<any> = [];

  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App,
			   public JsonService: JsonDataProvider, private auth: AuthServiceProvider) {
	  this.JsonService.getData(this.auth.getUserInfo(), "appelli").then(data => {
			for (let entry in data) {
                this.JsonService.getGeneric(data[entry].materiaurl).then(temp => {
                    for (let index in temp['profurl']) {
                        this.JsonService.getGeneric(temp['profurl'][index]).then(temp2 => {
                           temp['profurl'][index] = temp2;
                        });
                    }
                    
                    data[entry].materiaurl = temp; 
                });
                
                this.JsonService.getGeneric(data[entry].aulaurl).then(temp => {
                   data[entry].aulaurl = temp; 
                });
                
                this.appelli.push(data[entry]);
            }
	});
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ListaAppelliPage');
  }

   Navigate(info) {
       this.appCtrl.getRootNav().push(DettaglioAppelliPage, { param1: info });
   }

  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }
}

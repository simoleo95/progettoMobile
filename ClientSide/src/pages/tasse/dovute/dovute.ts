import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { JsonDataProvider } from '../../../providers/json-data/json-data';
import { AuthServiceProvider } from '../../../providers/auth-service/auth-service';

/**
 * Generated class for the DovutePage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-dovute',
  templateUrl: 'dovute.html',
})
export class DovutePage {
    
  tasse: Array<any> = [];

    constructor(public navCtrl: NavController, public navParams: NavParams, public JsonService: JsonDataProvider, private auth: AuthServiceProvider) {
        
       this.JsonService.getData(this.auth.getUserInfo(), "tasse").then(data => {
           for (let entry in data) {
               if(!data[entry].pagata) {
                   this.tasse.push(data[entry]);   
               }
           }
       });
    }

  ionViewDidLoad() {
    console.log('ionViewDidLoad DovutePage');
  }

}

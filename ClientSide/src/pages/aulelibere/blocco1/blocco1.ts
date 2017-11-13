import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { JsonDataProvider } from '../../../providers/json-data/json-data';
import { AuthServiceProvider } from '../../../providers/auth-service/auth-service';

/**
 * Generated class for the Blocco0Page page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-blocco1',
  templateUrl: 'blocco1.html'
})
export class Blocco1Page {
    
  aule: Array<any> = [];

  constructor(public navCtrl: NavController, public navParams: NavParams, public JsonService: JsonDataProvider, private auth: AuthServiceProvider) {
      this.JsonService.getGeneric("http://localhost:8088/MYUNIVAQ3/rest/generic/aule_libere").then(data => {
          for (let entry in data)
              if (data[entry].blocco == "1")
                  this.aule.push(data[entry]);
      });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Blocco1Page');
  }

}

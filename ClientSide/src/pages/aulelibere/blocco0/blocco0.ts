import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the Blocco0Page page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-blocco0',
  templateUrl: 'blocco0.html',
})
export class Blocco0Page {
auleLibere = [
      {nome: "A0.1", orario: "12.30"},
      {nome: "A1.3", orario: "14.00"}
    ];
  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Blocco0Page');
  }

}

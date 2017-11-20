import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the NomemateriaPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-nomemateria',
  templateUrl: 'nomemateria.html',
})
export class NomemateriaPage {
    
  info: Array<any> = [];

  constructor(public navCtrl: NavController, public navParams: NavParams) {
      this.info = navParams.get('param1');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad NomemateriaPage');
  }

}

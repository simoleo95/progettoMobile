import { Component } from '@angular/core';
import { IonicPage, NavController, App } from 'ionic-angular';

import { NomemateriaPage } from '../../nomemateria/nomemateria'

/**
 * Generated class for the Anno1Page page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-anno1',
  templateUrl: 'anno1.html',
})
export class Anno1Page {

  constructor(public navCtrl: NavController, public appCtrl: App) {
  }
    
  Navigate() {
      this.appCtrl.getRootNav().push(NomemateriaPage);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Anno1Page');
  }

}

import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { DovutePage } from './dovute/dovute';
import { PagatePage } from './pagate/pagate';

/**
 * Generated class for the TassePage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-tasse',
  templateUrl: 'tasse.html'
})
export class TassePage {

  dovute: any = DovutePage;
  pagate: any = PagatePage;
    
  constructor(public navCtrl: NavController, public navParams: NavParams) {
      
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad TassePage');
  }

}
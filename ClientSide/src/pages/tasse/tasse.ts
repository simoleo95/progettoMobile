import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';

import { DovutePage } from './dovute/dovute';
import { PagatePage } from './pagate/pagate';

import { AvatarPage } from '../avatar/avatar';

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
    
  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App) {
      
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad TassePage');
  }
    
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

}
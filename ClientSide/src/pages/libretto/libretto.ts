import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';

/**
 * Generated class for the LibrettoPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-libretto',
  templateUrl: 'libretto.html',
})
export class LibrettoPage {

  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LibrettoPage');
  }
    
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

}

import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';

import { Blocco0Page } from './blocco0/blocco0';
import { Blocco1Page } from './blocco1/blocco1';
import { Blocco2Page } from './blocco2/blocco2';

import { AvatarPage } from '../avatar/avatar';

/*
  Generated class for the  AulePage.

  See http://ionicframework.com/docs/v2/components/#navigation for more info on
  Ionic pages and navigation.
*/
@IonicPage()
@Component({
  selector: 'page-aule',
  templateUrl: 'aule.html'
})
export class AulePage {

  // this tells the tabs component which Pages
  // should be each tab's root Page
  blocco0: any = Blocco0Page;
  blocco1: any = Blocco1Page;
  blocco2: any = Blocco2Page;

  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App) {

  }

  ionViewDidLoad(){
    console.log('ionViewDidLoad AulePage')
  }

  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

}

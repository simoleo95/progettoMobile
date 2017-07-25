import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';

import { Anno1Page } from './anno1/anno1';
import { Anno2Page } from './anno2/anno2';
import { Anno3Page } from './anno3/anno3';

import { AvatarPage } from '../avatar/avatar';

@IonicPage()
@Component({
  selector: 'page-pianodistudi',
  templateUrl: 'pianodistudi.html',
})
export class PianodistudiPage {

  Anno1: any = Anno1Page;
  Anno2: any = Anno2Page;
  Anno3: any = Anno3Page;
    
  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PianodistudiPage');
  }
    
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

}

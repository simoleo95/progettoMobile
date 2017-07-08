import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { Anno1Page } from './anno1/anno1'
import { Anno2Page } from './anno2/anno2'
import { Anno3Page } from './anno3/anno3'

@IonicPage()
@Component({
  selector: 'page-pianodistudi',
  templateUrl: 'pianodistudi.html',
})
export class PianodistudiPage {

  Anno1: any = Anno1Page;
  Anno2: any = Anno2Page;
  Anno3: any = Anno3Page;
    
  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad PianodistudiPage');
  }

}

import { Component } from '@angular/core';
import { NavController, App } from 'ionic-angular';

import { AvatarPage } from '../avatar/avatar';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController, public appCtrl: App) {

  }
    
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

}

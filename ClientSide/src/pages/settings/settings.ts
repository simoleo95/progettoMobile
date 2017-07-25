import { Component } from '@angular/core';
import { NavController, App } from 'ionic-angular';

import { AvatarPage } from '../avatar/avatar';

@Component({
  selector: 'settingPage',
  templateUrl: 'settings.html'
})
export class SettingsPage {

  constructor(public navCtrl: NavController, public appCtrl: App) {

  }
      
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

}

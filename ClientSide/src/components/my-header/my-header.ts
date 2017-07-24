import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ViewController, App } from 'ionic-angular';
import { AvatarPage } from '../../pages/avatar/avatar'

@Component({
  selector: 'my-header',
  templateUrl: 'my-header.html'
})
export class MyHeaderComponent {

  constructor(public navCtrl: NavController, public navParams: NavParams, public viewCtrl: ViewController, public appCtrl: App) { }
    
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

}

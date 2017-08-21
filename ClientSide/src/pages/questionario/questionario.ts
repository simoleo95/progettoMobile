import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { ListaAppelliPage } from '../listaappelli/listaappelli'

/**
 * Generated class for the QuestionarioPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-questionario',
  templateUrl: 'questionario.html',
})
export class QuestionarioPage {

  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad QuestionarioPage');
  }

  Navigate() {
      this.appCtrl.getRootNav().push(ListaAppelliPage);
  }
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }
}

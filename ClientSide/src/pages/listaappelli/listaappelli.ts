import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { DettaglioAppelliPage } from '../dettaglioappelli/dettaglioappelli'

/**
 * Generated class for the ListaAppelliPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-listaappelli',
  templateUrl: 'listaappelli.html',
})
export class ListaAppelliPage {
  listaAppelli = [
      {nomeMateria: "Applicazione per Dispositivi Mobili", data: "01/01/1001"}
  ]

  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ListaAppelliPage');
  }

  Navigate() {
      this.appCtrl.getRootNav().push(DettaglioAppelliPage);
  }

  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }
}

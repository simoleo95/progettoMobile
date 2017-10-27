import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { QuestionarioPage} from '../questionario/questionario'

/**
 * Generated class for the DettaglioAppelliPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-dettaglioappelli',
  templateUrl: 'dettaglioappelli.html',
})
export class DettaglioAppelliPage {
  
  appello = {
    nomeMateria: "Applicazioni per Dispositivi Mobili",
    docene: "Amleto De Salle",
    data: "01/01/1001",
    ora: "10:00",
    tipologia: "Orale",
    aula: "A1.2",
    scadenza: "30/12/1000"
  }

  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad DettaglioAppelliPage');
  }

  Navigate() {
      this.appCtrl.getRootNav().push(QuestionarioPage);
  }

  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }
}

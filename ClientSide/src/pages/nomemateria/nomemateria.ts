import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the NomemateriaPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-nomemateria',
  templateUrl: 'nomemateria.html',
})
export class NomemateriaPage {
  dettaglio = {
    nomeMateria: "Applicazioni per Dispositivi Mobili",
    docente: "Amleto De Salle",
    annoAccademico: "2017/2018",
    crediti: 6
  }

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad NomemateriaPage');
  }

}

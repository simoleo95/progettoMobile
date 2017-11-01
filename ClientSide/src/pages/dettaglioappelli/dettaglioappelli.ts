import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { QuestionarioPage } from '../questionario/questionario'
import { ConfermaPrenotazionePage } from '../confermaprenotazione/confermaprenotazione'
import { AuthServiceProvider } from '../../providers/auth-service/auth-service';
import { JsonDataProvider } from '../../providers/json-data/json-data';

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
  
  appello: {idMateria: string, nomeMateria: string, docenti: {nome: string, cognome: string}[], data: string,
			aula: string, descrizione: string, scadenza: string, tipologia: string};

  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App,
    public JsonService: JsonDataProvider, private auth: AuthServiceProvider) {
	  this.appello = navParams.get('appello');
	  this.appello.scadenza = 'Non disponibile';
	  this.appello.tipologia = 'Non disponibile';
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad DettaglioAppelliPage');
  }

  Navigate() {
    // uncomment when server works
    //if (this.JsonService.compiledQuestionary(this.appello.idMateria)) {
    // this.JsonService.book(this.appello.idMateria, this.appello.data).then(() => {
      //  this.appCtrl.getRootNav().push(ConfermaPrenotazionePage, { appello: this.appello });
    // });
    //} else {
      this.appCtrl.getRootNav().push(QuestionarioPage, { appello: this.appello });
    //}
  }

  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }
}

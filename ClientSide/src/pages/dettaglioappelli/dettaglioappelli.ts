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
  
  appello: {
  idMateria: string,
  nomeMateria: string,
  docenti: Array<{aaaa: string, cognome: string}>,
  data: string,
			aula: string,
            descrizione: string,
            scadenza: string,
            tipologia: string} = {
             idMateria: "",
  nomeMateria: "",
   docenti:[],
   data:"",
   aula:"",
   descrizione: "",
            scadenza: "",
            tipologia: ""
   
            };

  // appello: {idMateria: string, nomeMateria: string, docenti: {nome: string, cognome: string}[], data: string,
	// 		aula: string, descrizione: string, scadenza: string, tipologia: string} = {};
  //
  // constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App) {
	//   this.appello = navParams.get('appello');
	//   this.appello.scadenza = 'Non disponibile';
	//   this.appello.tipologia = 'Non disponibile';
  // }
  //
  // ionViewDidLoad() {
  //   console.log('ionViewDidLoad DettaglioAppelliPage');
  // }
  //
  // Navigate(idMateria: string) {
  //     this.appCtrl.getRootNav().push(QuestionarioPage, {materia: idMateria});
  // }
  //
  // openAvatar() {
  //     this.appCtrl.getRootNav().push(AvatarPage);
  // }
}

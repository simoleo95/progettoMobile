import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { JsonDataProvider } from '../../providers/json-data/json-data';
import { AuthServiceProvider } from '../../providers/auth-service/auth-service';
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
  listaAppelli: Array<{
    nomeMateria: string, data: string,
    info: {
      idMateria: string, nomeMateria: string, docenti: { nome: string, cognome: string }[],
      data: string, aula: string, descrizione: string
    }
  }> = [];

  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App,
    public JsonService: JsonDataProvider, private auth: AuthServiceProvider) {
    this.listaAppelli = [ // test data, remove when server works
      {
        nomeMateria: "Applicazioni per dispositivi mobili",
        data: "07/11/2017 10:00",
        info: {
          idMateria: "01",
          nomeMateria: "Applicazioni per dispositivi mobili",
          docenti: [
            { nome: "Pinco", cognome: "Pallino" }
          ],
          data: "07/11/2017 10:00",
          aula: "2.5",
          descrizione: "Appello novembre"
        }
      },
      {
        nomeMateria: "Altra bellerrima materia",
        data: "10/11/2017 12:00",
        info: {
          idMateria: "02",
          nomeMateria: "Altra bellerrima materia",
          docenti: [
            { nome: "Primo", cognome: "Prof" },
            { nome: "Secondo", cognome: "Prof" }
          ],
          data: "10/11/2017 12:00",
          aula: "2.3",
          descrizione: "Appello straordinario"
        }
      }
    ];
    /* uncomment when server works
    this.JsonService.getData(this.auth.getUserInfo()).then(data => {
      for (let appello in data['appelli']) {
        this.listaAppelli.push({
          nomeMateria: appello['materia']['nome'],
          data: appello['data'],
          info: {
            idMateria: appello['materia']['id'],
            nomeMateria: appello['materia']['nome'],
            docenti: appello['materia']['professori'],
            data: appello['data'],
            aula: appello['aula'],
            descrizione: appello['descrizione']
          }
        });	   
      }		   
  }); */
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ListaAppelliPage');
  }

  Navigate(info: {
    idMateria: string, nomeMateria: string, docenti: { nome: string, cognome: string }[],
    data: string, aula: string, descrizione: string
  }) {
    this.appCtrl.getRootNav().push(DettaglioAppelliPage, { appello: info });
  }

  openAvatar() {
    this.appCtrl.getRootNav().push(AvatarPage);
  }
}

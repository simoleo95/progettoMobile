import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { QuestionarioPage } from '../questionario/questionario';
import { ConfermaPrenotazionePage } from '../confermaprenotazione/confermaprenotazione';
import { QuestionarioPage } from '../questionario/questionario';

import { JsonDataProvider } from '../../providers/json-data/json-data';
import { AuthServiceProvider } from '../../providers/auth-service/auth-service';

@IonicPage()
@Component({
  selector: 'page-dettaglioappelli',
  templateUrl: 'dettaglioappelli.html',
})
export class DettaglioAppelliPage {
    info: Array<any> = [];
    
    constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App, public JsonService: JsonDataProvider, private auth: AuthServiceProvider) {
        this.info = navParams.get('param1');
    }
    
  Navigate() {
      
      // Per adesso solo controllo su primo prof della lista
      this.JsonService.getQuestionario(this.auth.getUserInfo(), this.info['materiaurl'].id, this.info['materiaurl']['profurl'][0].id).then(data => {
          if (data == "questionario ancora non inserito") {
              this.appCtrl.getRootNav().push(QuestionarioPage, {'param1': this.info});
          }
          else {
            this.appCtrl.getRootNav().push(ConfermaPrenotazionePage, {'param1': this.info});   
          }
      });
      
      //this.appCtrl.getRootNav().push(NomemateriaPage);
  }
}

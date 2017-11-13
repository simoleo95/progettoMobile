import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { QuestionarioPage } from '../questionario/questionario'

@IonicPage()
@Component({
  selector: 'page-dettaglioappelli',
  templateUrl: 'dettaglioappelli.html',
})
export class DettaglioAppelliPage {
    info: Array<any> = [];
    
    constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App) {
        this.info = navParams.get('param1');
    }
}

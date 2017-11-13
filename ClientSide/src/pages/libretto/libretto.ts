import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, App } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { JsonDataProvider } from '../../providers/json-data/json-data';
import { AuthServiceProvider } from '../../providers/auth-service/auth-service';

/**
 * Generated class for the LibrettoPage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-libretto',
  templateUrl: 'libretto.html',
})
export class LibrettoPage {
//  libretto: {
//	  mediaAritmetica: number,
//	  mediaPonderata: number,
//	  esami: Array<{nomeMateria: string, data: string, voto: string, cfu: number}>} = {
//		  mediaAritmetica: 0,
//		  mediaPonderata: 0,
//		  esami: []
//	  };
    
    mediaAritmetica: number;
    mediaPonderata: number;
    esami: Array<any> = [];

  constructor(public navCtrl: NavController, public navParams: NavParams, public appCtrl: App,
			   public JsonService: JsonDataProvider, private auth: AuthServiceProvider) {
	  
      this.JsonService.getData(this.auth.getUserInfo(), "libretto").then(data => {
            for(let entry in data) {
                this.JsonService.getGeneric(data[entry].materiaurl).then(tmp => {
                    data[entry].materiaurl = tmp;
                });
                
                this.JsonService.getGeneric(data[entry].appellourl).then(tmp => {
                    data[entry].appellourl = tmp;
                });
                
                this.esami.push(data[entry]);
            }
      });
        
      this.calcolaMedia();
       
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LibrettoPage');
  }
    
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }
      
  calcolaMedia() {
    // Da completare
  }

}

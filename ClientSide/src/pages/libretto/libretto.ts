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
	  
      this.JsonService.getData(this.auth.getUserInfo()).then(data => {
          
        for (let entry in data['libretto']) {
            this.esami.push(data['libretto'][entry]);
        }
//		  let crediti: number = 0;
//		  let votoTotale: number = 0;
//		  let numeratorePonderata: number = 0;
//		  let numeroMaterie: number = 0;
//           for (let esame in data['libretto']) {
//			   let voto: string;
//			   if(esame['materia']['tipocfu'] === 'F') {
//				   voto = 'Superato';
//			   } else {
//				   numeroMaterie++;
//				   crediti += esame['materia']['cfu'];
//				   if (esame['voto'] > 30) {
//					   voto = '30L';
//					   votoTotale += 30;
//				   } else {
//						votoTotale += esame['voto'];
//				   }
//				   numeratorePonderata += parseInt(voto, 10) * esame['materia']['cfu'];
//			   }
//			   this.libretto.esami.push({
//				  nomeMateria: esame['materia']['nome'],
//				   data: esame['appello']['data'],
//				   voto: voto,
//				   cfu: esame['materia']['cfu']
//			   });
//           }
//		  this.libretto.mediaAritmetica = votoTotale / numeroMaterie;
//		  this.libretto.mediaPonderata = numeratorePonderata / crediti;
       });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LibrettoPage');
  }
    
  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

}

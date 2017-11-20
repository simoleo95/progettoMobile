import { Component, ViewChild } from '@angular/core';
import { Calendar } from '@ionic-native/calendar';
import { IonicPage, NavController, NavParams, Platform, Navbar } from 'ionic-angular';
import { HomePage } from '../home/home';
import { JsonDataProvider } from '../../providers/json-data/json-data';
import { AuthServiceProvider } from '../../providers/auth-service/auth-service';

@IonicPage()
@Component({
  selector: 'page-confermaprenotazione',
  templateUrl: 'confermaprenotazione.html',
})
export class ConfermaPrenotazionePage {
  @ViewChild(Navbar) navBar: Navbar;

   info: Array<any>;
   msg: String = "";
   
  constructor(public navCtrl: NavController, public navParams: NavParams,
    public platform: Platform, private calendar: Calendar,
    public JsonService: JsonDataProvider, private auth: AuthServiceProvider) {
      this.info = navParams.get('param1');
      
      this.JsonService.putIscritto(this.auth.getUserInfo(), this.info.id).then(data => {
          if (data == "errore nel server")
              this.msg = "Prenotazione già effettuata!";
          else
              this.msg = "Prenotazione effettuata con successo!";
      });
  }

  ionViewDidLoad() {
    this.platform.registerBackButtonAction(() => {
      this.navCtrl.popTo(HomePage);
    });
    this.navBar.backButtonClick = (e: UIEvent) => {
      this.navCtrl.popTo(HomePage);
    }
  }

  addToCalendar() {
	let dmy = this.appello.data.split("/"); // [dd, mm, YYYY HH:mm]
	let hm = dmy[2].split(" ");
	dmy[2] = hm[0]; // dmy = [dd, mm, YYYY]
	hm = hm[1].split(":"); // hm = [hh, mm]
    this.calendar.createEvent(this.appello.nomeMateria,
      "Aula " + this.appello.aula,
      null,
      new Date(parseInt(dmy[2], 10), parseInt(dmy[1], 10) - 1,
		parseInt(dmy[0], 10), parseInt(hm[1], 10), parseInt(hm[2], 10))
	);
  }

}

import { Component, ViewChild } from '@angular/core';
import { Calendar } from '@ionic-native/calendar';
import { IonicPage, NavController, NavParams, Platform, Navbar } from 'ionic-angular';
import { HomePage } from '../home/home'

@IonicPage()
@Component({
  selector: 'page-confermaprenotazione',
  templateUrl: 'confermaprenotazione.html',
})
export class ConfermaPrenotazionePage {
  @ViewChild(Navbar) navBar: Navbar;
  appello: {
    idMateria: string, nomeMateria: string, docenti: { nome: string, cognome: string }[], data: string,
    aula: string, descrizione: string, scadenza: string, tipologia: string
  };
  constructor(public navCtrl: NavController, public navParams: NavParams,
    public platform: Platform, private calendar: Calendar) {
    this.appello = navParams.get('appello');
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

import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the Blocco0Page page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */
@IonicPage()
@Component({
  selector: 'page-blocco1',
  templateUrl: 'blocco1.html'
})
export class Blocco1Page {
  auleLibere = [
    {nome: "2.5", orario: "16:00"},
    {nome: "1.7", orario: "13:30"},
    {nome: "0.5", orario: "16:00"},
    {nome: "1.7", orario: "25:70"},
    {nome: "2.5", orario: "16:00"},
    {nome: "1.7", orario: "13:30"},
    {nome: "2.5", orario: "16:00"},
    {nome: "1.7", orario: "13:30"},
    {nome: "2.5", orario: "16:00"},
    {nome: "1.7", orario: "13:30"},
    {nome: "2.5", orario: "16:00"},
    {nome: "1.7", orario: "13:30"},
    {nome: "2.5", orario: "16:00"},
    {nome: "1.7", orario: "13:30"}
  ];

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Blocco1Page');
  }

}

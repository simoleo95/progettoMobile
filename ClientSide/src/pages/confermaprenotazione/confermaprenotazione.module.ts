import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ConfermaPrenotazionePage } from './confermaprenotazione';

@NgModule({
  declarations: [
    ConfermaPrenotazionePage,
  ],
  imports: [
    IonicPageModule.forChild(ConfermaPrenotazionePage),
  ],
  exports: [
    ConfermaPrenotazionePage
  ]
})
export class ConfermaPrenotazionePageModule {}

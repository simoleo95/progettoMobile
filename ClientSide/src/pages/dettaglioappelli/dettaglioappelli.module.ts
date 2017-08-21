import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { DettaglioAppelliPage } from './dettaglioappelli';

@NgModule({
  declarations: [
    DettaglioAppelliPage,
  ],
  imports: [
    IonicPageModule.forChild(DettaglioAppelliPage),
  ],
  exports: [
    DettaglioAppelliPage
  ]
})
export class DettaglioAppelliPageModule {}

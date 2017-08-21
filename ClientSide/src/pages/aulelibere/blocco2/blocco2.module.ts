import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { Blocco2Page } from './blocco2';

@NgModule({
  declarations: [
    Blocco2Page,
  ],
  imports: [
    IonicPageModule.forChild(Blocco2Page),
  ],
  exports: [
    Blocco2Page
  ]
})
export class Blocco2PageModule {}

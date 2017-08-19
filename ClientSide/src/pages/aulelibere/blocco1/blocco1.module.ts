import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { Blocco1Page } from './blocco1';

@NgModule({
  declarations: [
    Blocco1Page,
  ],
  imports: [
    IonicPageModule.forChild(Blocco1Page),
  ],
  exports: [
    Blocco1Page
  ]
})
export class Blocco1PageModule {}

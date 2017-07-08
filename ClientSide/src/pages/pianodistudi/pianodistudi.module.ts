import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { PianodistudiPage } from './pianodistudi';

@NgModule({
  declarations: [
    PianodistudiPage,
  ],
  imports: [
    IonicPageModule.forChild(PianodistudiPage),
  ],
  exports: [
    PianodistudiPage
  ]
})
export class PianodistudiPageModule {}

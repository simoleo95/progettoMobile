import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { NomemateriaPage } from './nomemateria';

@NgModule({
  declarations: [
    NomemateriaPage,
  ],
  imports: [
    IonicPageModule.forChild(NomemateriaPage),
  ],
  exports: [
    NomemateriaPage
  ]
})
export class NomemateriaPageModule {}

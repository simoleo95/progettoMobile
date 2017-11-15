import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { OrarioPage } from './orario';

@NgModule({
  declarations: [
    OrarioPage,
  ],
  imports: [
    IonicPageModule.forChild(OrarioPage),
  ],
  exports: [
    OrarioPage
  ]
})
export class OrarioPageModule {}

import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { LibrettoPage } from './libretto';

@NgModule({
  declarations: [
    LibrettoPage,
  ],
  imports: [
    IonicPageModule.forChild(LibrettoPage),
  ],
  exports: [
    LibrettoPage
  ]
})
export class LibrettoPageModule {}

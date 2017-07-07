import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { DovutePage } from './dovute';

@NgModule({
  declarations: [
    DovutePage,
  ],
  imports: [
    IonicPageModule.forChild(DovutePage),
  ],
  exports: [
    DovutePage
  ]
})
export class DovutePageModule {}

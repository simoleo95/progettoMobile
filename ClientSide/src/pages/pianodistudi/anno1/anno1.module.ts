import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { Anno1Page } from './anno1';

@NgModule({
  declarations: [
    Anno1Page,
  ],
  imports: [
    IonicPageModule.forChild(Anno1Page),
  ],
  exports: [
    Anno1Page
  ]
})
export class Anno1PageModule {}

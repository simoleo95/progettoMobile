import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { AulePage } from './aule';

@NgModule({
  declarations: [
    AulePage,
  ],
  imports: [
    IonicPageModule.forChild(AulePage),
  ],
  exports: [
    AulePage
  ]
})
export class AulePageModule {}

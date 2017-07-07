import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { PagatePage } from './pagate';

@NgModule({
  declarations: [
    PagatePage,
  ],
  imports: [
    IonicPageModule.forChild(PagatePage),
  ],
  exports: [
    PagatePage
  ]
})
export class PagatePageModule {}

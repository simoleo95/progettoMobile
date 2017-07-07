import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TassePage } from './tasse';

@NgModule({
  declarations: [
    TassePage,
  ],
  imports: [
    IonicPageModule.forChild(TassePage),
  ],
  exports: [
    TassePage
  ]
})
export class TassePageModule {}

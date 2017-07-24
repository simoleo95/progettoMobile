import { NgModule } from '@angular/core';
import { IonicModule } from 'ionic-angular';
import { MyHeaderComponent } from './my-header';

@NgModule({
  declarations: [
    MyHeaderComponent,
  ],
  imports: [
    IonicModule,
  ],
  exports: [
    MyHeaderComponent
  ]
})
export class MyHeaderComponentModule {}

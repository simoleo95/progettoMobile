import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ListaAppelliPage } from './listaappelli';

@NgModule({
  declarations: [
    ListaAppelliPage,
  ],
  imports: [
    IonicPageModule.forChild(ListaAppelliPage),
  ],
  exports: [
    ListaAppelliPage
  ]
})
export class ListaAppelliPageModule {}

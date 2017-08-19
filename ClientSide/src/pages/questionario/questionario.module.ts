import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { QuestionarioPage } from './questionario';

@NgModule({
  declarations: [
    QuestionarioPage,
  ],
  imports: [
    IonicPageModule.forChild(QuestionarioPage),
  ],
  exports: [
    QuestionarioPage
  ]
})
export class QuestionarioPageModule {}

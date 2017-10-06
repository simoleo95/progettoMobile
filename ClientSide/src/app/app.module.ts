import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { ListPage } from '../pages/list/list';
import { SettingsPage } from '../pages/settings/settings';
import { AvatarPage } from '../pages/avatar/avatar';
import { TabsPage } from '../pages/orario/tabs';
import { Page1Page } from '../pages/orario/page1/page1';
import { Page2Page } from '../pages/orario/page2/page2';
import { Page3Page } from '../pages/orario/page3/page3';
import { TassePage } from '../pages/tasse/tasse';
import { DovutePage } from '../pages/tasse/dovute/dovute';
import { PagatePage } from '../pages/tasse/pagate/pagate';
import { LibrettoPage } from '../pages/libretto/libretto';
import { PianodistudiPage } from '../pages/pianodistudi/pianodistudi';
import { Anno1Page } from '../pages/pianodistudi/anno1/anno1';
import { Anno2Page } from '../pages/pianodistudi/anno2/anno2';
import { Anno3Page } from '../pages/pianodistudi/anno3/anno3';
import { NomemateriaPage } from '../pages/nomemateria/nomemateria';
import { AulePage } from '../pages/aulelibere/aule';
import { Blocco0Page } from '../pages/aulelibere/blocco0/blocco0';
import { Blocco1Page } from '../pages/aulelibere/blocco1/blocco1';
import { Blocco2Page } from '../pages/aulelibere/blocco2/blocco2';
import { DettaglioAppelliPage } from '../pages/dettaglioappelli/dettaglioappelli';
import { ListaAppelliPage } from '../pages/listaappelli/listaappelli';
import { QuestionarioPage } from '../pages/questionario/questionario';
import { LoginPage } from '../pages/login/login';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { AuthServiceProvider } from '../providers/auth-service/auth-service';
import { JsonDataProvider } from '../providers/json-data/json-data';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    ListPage,
    SettingsPage,
    AvatarPage,
    Page1Page,
    Page2Page,
    TabsPage,
    Page3Page,
    TassePage,
    DovutePage,
    PagatePage,
    LibrettoPage,
    PianodistudiPage,
    Anno1Page,
    Anno2Page,
    Anno3Page,
    NomemateriaPage,
    AulePage,
    Blocco0Page,
    Blocco1Page,
    Blocco2Page,
    DettaglioAppelliPage,
    ListaAppelliPage,
    QuestionarioPage,
    LoginPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp,{tabsPlacement: 'bottom'}),
    HttpModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    ListPage,
    SettingsPage,
    AvatarPage,
    Page1Page,
    Page2Page,
    TabsPage,
    Page3Page,
    TassePage,
    DovutePage,
    PagatePage,
    LibrettoPage,
    PianodistudiPage,
    Anno1Page,
    Anno2Page,
    Anno3Page,
    NomemateriaPage,
    AulePage,
    Blocco0Page,
    Blocco1Page,
    Blocco2Page,
    DettaglioAppelliPage,
    ListaAppelliPage,
    QuestionarioPage,
    LoginPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    AuthServiceProvider,
    JsonDataProvider,
  ]
})
export class AppModule {}

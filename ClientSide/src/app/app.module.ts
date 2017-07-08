import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { ListPage } from '../pages/list/list';
import { SettingsPage } from '../pages/settings/settings';
import { AvatarPage } from '../pages/avatar/avatar';
import { TabsPage } from '../pages/tabs/tabs';
import { Page1Page } from '../pages/page1/page1';
import { Page2Page } from '../pages/page2/page2';
import { Page3Page } from '../pages/page3/page3';
import { TassePage } from '../pages/tasse/tasse';
import { DovutePage } from '../pages/tasse/dovute/dovute';
import { PagatePage } from '../pages/tasse/pagate/pagate';
import { LibrettoPage } from '../pages/libretto/libretto';
import { PianodistudiPage } from '../pages/pianodistudi/pianodistudi';
import { Anno1Page } from '../pages/pianodistudi/anno1/anno1';
import { Anno2Page } from '../pages/pianodistudi/anno2/anno2';
import { Anno3Page } from '../pages/pianodistudi/anno3/anno3';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

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
    Anno3Page
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp,{tabsPlacement: 'bottom'})
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
    Anno3Page
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}

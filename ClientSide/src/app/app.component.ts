import { Component, ViewChild } from '@angular/core';
import { Nav, Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { AvatarPage } from '../pages/avatar/avatar';
import { HomePage } from '../pages/home/home';
import { SettingsPage} from '../pages/settings/settings';
import { TabsPage } from '../pages/orario/tabs';
import { TassePage } from '../pages/tasse/tasse';
import { LibrettoPage } from '../pages/libretto/libretto';
import { PianodistudiPage } from '../pages/pianodistudi/pianodistudi';
import { LoginPage } from '../pages/login/login';
import { AulePage } from '../pages/aulelibere/aule';
import { ListaAppelliPage } from '../pages/listaappelli/listaappelli';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage: any = LoginPage;

  pages: Array<{icon: string, title: string, component: any}>;

  constructor(public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen) {
    this.initializeApp();

    // used for an example of ngFor and navigation
    this.pages = [
      { icon: 'home', title: 'Home', component: HomePage },
      { icon: 'time', title: 'Orario', component: TabsPage },
      { icon: 'cash', title: 'Tasse', component: TassePage },
      { icon: 'book', title: 'Libretto', component: LibrettoPage },
      { icon: 'school', title: 'Piano di studi', component: PianodistudiPage },
      { icon: 'school', title: 'Aule Libere', component: AulePage },
      { icon: 'school', title: 'Lista Appelli', component: ListaAppelliPage },
      { icon: 'settings', title: 'Impostazioni', component: SettingsPage }
     // { icon: 'contact', title: 'Profilo' , component: AvatarPage}
    ];

  }

  initializeApp() {
    this.platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }

  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
    this.nav.setRoot(page.component);
  }
}

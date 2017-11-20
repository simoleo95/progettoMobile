import { Component, ViewChild } from '@angular/core';
import { Nav, Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { AvatarPage } from '../pages/avatar/avatar';
import { HomePage } from '../pages/home/home';
import { SettingsPage} from '../pages/settings/settings';
import { TassePage } from '../pages/tasse/tasse';
import { LibrettoPage } from '../pages/libretto/libretto';
import { PianodistudiPage } from '../pages/pianodistudi/pianodistudi';
import { LoginPage } from '../pages/login/login';
import { AulePage } from '../pages/aulelibere/aule';
import { ListaAppelliPage } from '../pages/listaappelli/listaappelli';
import { OrarioPage } from '../pages/orario/orario';
import { AuthServiceProvider } from '../providers/auth-service/auth-service';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage: any = LoginPage;
  pages: Array<{icon: string, title: string, component: any}>;

  constructor(public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen, private auth: AuthServiceProvider) {
    this.initializeApp();

    // used for an example of ngFor and navigation
    this.pages = [
      { icon: 'home', title: 'Home', component: HomePage },
      { icon: 'time', title: 'Orario', component: OrarioPage },
      { icon: 'cash', title: 'Tasse', component: TassePage },
      { icon: 'book', title: 'Libretto', component: LibrettoPage },
      { icon: 'school', title: 'Piano di studi', component: PianodistudiPage },
      { icon: 'information-circle', title: 'Aule Libere', component: AulePage },
      { icon: 'create', title: 'Lista Appelli', component: ListaAppelliPage },
      { icon: 'settings', title: 'Impostazioni', component: SettingsPage }
     // { icon: 'contact', title: 'Profilo' , component: AvatarPage}
    ];
      //this.user.user = this.user.user.CharAt(0).toUpperCase() + this.user.user.slice(1);
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

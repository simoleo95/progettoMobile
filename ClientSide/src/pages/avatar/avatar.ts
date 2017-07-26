import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { LoginPage } from '../login/login'; 

import { AuthServiceProvider } from '../../providers/auth-service/auth-service';

@Component({
  selector: 'page-avatar',
  templateUrl: 'avatar.html'
})

export class AvatarPage {
  username='';
  email='';

  constructor(public nav: NavController, private auth: AuthServiceProvider) {
    let info = this.auth.getUserInfo();
    this.username = info['name'];
    this.email = info['email'];
  }

  public logout() {
    this.auth.logout().subscribe(succ => {
      this.nav.setRoot(LoginPage)
    });
  }

}

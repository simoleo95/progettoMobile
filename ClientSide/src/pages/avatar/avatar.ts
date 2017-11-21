import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { LoginPage } from '../login/login'; 

import { AuthServiceProvider } from '../../providers/auth-service/auth-service';
import { JsonDataProvider } from '../../providers/json-data/json-data';

@Component({
  selector: 'page-avatar',
  templateUrl: 'avatar.html'
})

export class AvatarPage {
    
  info: Array<any> = [];

  constructor(public nav: NavController, private auth: AuthServiceProvider, public JsonService: JsonDataProvider) {
      this.JsonService.getData(this.auth.getUserInfo()).then(data => {
            this.info.push(data);
      });
  }

  public logout() {
    this.auth.logout().subscribe(succ => {
      this.nav.setRoot(LoginPage)
    });
  }

}

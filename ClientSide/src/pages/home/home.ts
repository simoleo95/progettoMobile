import { Component, ViewChild } from '@angular/core';
import { NavController, App, AlertController, Nav, IonicPage  } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { FeedProvider, Feed } from '../../providers/feed/feed';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  rootPage = 'FeedListPage';
  feeds: Feed[];
  constructor(public nav: NavController, public appCtrl: App, private navController: NavController, private feedProvider: FeedProvider, public alertCtrl: AlertController) { }

  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

  public addFeed() {
    let prompt = this.alertCtrl.create({
      title: 'Add Feed URL',
      inputs: [
        {
          name: 'name',
          placeholder: 'The best Feed ever'
        },
        {
          name: 'url',
          placeholder: 'http://www.myfeedurl.com/feed'
        },
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel'
        },
        {
          text: 'Save',
          handler: data => {
            let newFeed = new Feed(data.name, data.url);
            this.feedProvider.addFeed(newFeed).then(
              res => {
                this.loadFeeds();
              }
            );
          }
        }
      ]
    });
    prompt.present();
  }

  private loadFeeds() {
    this.feedProvider.getSavedFeeds().then(
      allFeeds => {
        this.feeds = allFeeds;
      });
  }

  public openFeed(feed: Feed) {
    this.nav.setRoot('FeedListPage', { 'selectedFeed': feed });
  }

  public ionViewWillEnter() {
    this.loadFeeds();
  }


}

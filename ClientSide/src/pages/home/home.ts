import { Component, ViewChild } from '@angular/core';
import { NavController, App, AlertController, Nav, IonicPage  } from 'ionic-angular';
import { AvatarPage } from '../avatar/avatar';
import { InAppBrowser } from '@ionic-native/in-app-browser';
import { FeedProvider, FeedItem, Feed } from '../../providers/feed/feed';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  rootPage = 'FeedListPage';
  feeds: Feed[];
  
  constructor(public nav: NavController, public appCtrl: App, private navController: NavController, private feedProvider: FeedProvider, public alertCtrl: AlertController, public iab: InAppBrowser) {
    
      this.feedProvider.getArticlesForUrl('http://www.disim.univaq.it/didattica/content.php?fid=rss&pid=193&did=8').subscribe(res => {
        this.feeds = res;
      }); 
  }

  openAvatar() {
      this.appCtrl.getRootNav().push(AvatarPage);
  }

  private loadFeeds() {
    this.feedProvider.getSavedFeeds().then(
      allFeeds => {
        this.feeds = allFeeds;
      });
  }

  public openArticle(url: string) {
    this.iab.create(url, '_blank');
  }

//  public openFeed(feed: Feed) {
//    this.nav.setRoot('FeedListPage', { 'selectedFeed': feed });
//  }

}

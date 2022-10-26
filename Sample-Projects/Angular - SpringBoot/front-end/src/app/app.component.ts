import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { RouteType } from './types/FormTypes';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  public isLoggedIn: boolean = false;
  public isValidBrowser: boolean = true;
  routes: RouteType[] = [
    {
      route: 'home',
      name: 'home',
    },
    {
      route: 'course',
      name: 'course',
    },
    {
      route: 'course-search',
      name: 'search',
    },
    {
      route: 'contact',
      name: 'contact',
    },
    {
      route: 'about',
      name: 'about',
    },
  ];

  constructor(private router: Router, private translate: TranslateService) {}

  ngOnInit() {
    this.checkValidBrowser();
  }

  checkValidBrowser() {
    let nAgt = navigator.userAgent;
    let fullVersion: string = '' + parseFloat(navigator.appVersion);
    let nameOffset: any, verOffset: any, ix: any;
    if (nAgt.indexOf('Trident') != -1 && nAgt.indexOf('MSIE') != -1) {
      this.isValidBrowser = false;
    } else if ((verOffset = nAgt.indexOf('Chrome')) != -1) {
      fullVersion = nAgt.substring(verOffset + 7);
      let fullVersionNumber = this.getBrowserFullVersion(fullVersion);
      if (fullVersionNumber && fullVersionNumber < 44) {
        this.isValidBrowser = false;
      }
    } else if ((verOffset = nAgt.indexOf('Firefox')) != -1) {
      fullVersion = nAgt.substring(verOffset + 8);
      let fullVersionNumber = this.getBrowserFullVersion(fullVersion);
      if (fullVersionNumber && fullVersionNumber < 36) {
        this.isValidBrowser = false;
      }
    }
  }

  getBrowserFullVersion(fullVersion: string) {
    let majorVersion: number, ix: number;
    // trim the fullVersion string at semicolon/space if present
    if ((ix = fullVersion.indexOf(';')) != -1)
      fullVersion = fullVersion.substring(0, ix);
    if ((ix = fullVersion.indexOf(' ')) != -1)
      fullVersion = fullVersion.substring(0, ix);

    majorVersion = parseInt('' + fullVersion, 10);
    if (isNaN(majorVersion)) {
      fullVersion = '' + parseFloat(navigator.appVersion);
      majorVersion = parseInt(navigator.appVersion, 10);
    }
    return majorVersion;
  }

  login(event) {
    this.isLoggedIn = event;
  }
}

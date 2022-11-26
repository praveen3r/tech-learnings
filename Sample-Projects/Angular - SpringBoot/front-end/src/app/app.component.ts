import { Component, HostListener, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MessageComponent } from './lib/modal/message/message.component';
import { AuthenticationService } from './services/common/authentication.service';
import { Routes } from './utils/Routes';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  public isLoggedIn: boolean = false;
  public isValidBrowser: boolean = true;
  public routes = Routes;

  constructor(
    private router: Router,
    private translate: TranslateService,
    private authentication: AuthenticationService,
    private dialogService: MatDialog
  ) {}

  ngOnInit() {
    this.authentication.loggedInChange.subscribe((data) => {
      this.isLoggedIn = data;
    });
  }

  //disable browser refresh for F5, ctrl+f5 and ctrl+r
  @HostListener('document:keydown', ['$event'])
  processKeyDown(event: KeyboardEvent) {
    var input_key = event.code;
    if (
      input_key === 'F5' ||
      input_key === 'F10' ||
      input_key === 'F11' ||
      input_key === 'F12'
    ) {
      //F5, F10, F11, F12
      this.disableKeyboardNavigation(event);
    } else if (event.ctrlKey) {
      // Ctrl + R, Ctrl + Shift + R
      if (input_key === 'KeyR') {
        this.disableKeyboardNavigation(event);
      }
    }
  }

  disableKeyboardNavigation(event: KeyboardEvent) {
    const dialogRef = this.dialogService.open(MessageComponent, {
      data: this.translate.instant('msg.operationNotAllow'),
    });
    event.preventDefault();
    event.stopPropagation();
  }
}

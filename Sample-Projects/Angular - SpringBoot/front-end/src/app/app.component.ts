import { Component, HostListener, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { MessageComponent } from './lib/modal/message/message.component';
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
    private dialogService: MatDialog
  ) {}

  ngOnInit() {}

  //disable browser refresh for F5, ctrl+f5 and ctrl+r
  @HostListener('document:keydown', ['$event'])
  processKeyDown(event: KeyboardEvent) {
    var input_key = event.code;
    console.log(input_key);

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

  login(event) {
    this.isLoggedIn = event;
  }
}

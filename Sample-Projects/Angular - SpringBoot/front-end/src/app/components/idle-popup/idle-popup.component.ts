import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { interval } from 'rxjs';
import { take } from 'rxjs/operators';
import { AuthenticationService } from './../../services/common/authentication.service';
import { IdleService } from './../../services/common/idle.service';

@Component({
  selector: 'app-idle-popup',
  templateUrl: './idle-popup.component.html',
  styles: [],
})
export class IdlePopupComponent implements OnInit {
  private secondsCounter = interval(1000).pipe(take(10));
  private subscription: any;
  public timer: number = 10;

  constructor(
    public dialogRef: MatDialogRef<IdlePopupComponent>,
    private authentication: AuthenticationService,
    private router: Router,
    private idleService: IdleService
  ) {}

  ngOnInit() {
    this.subscription = this.secondsCounter.subscribe((val) => {
      if (val == 9) {
        this.subscription.unsubscribe();
        this.onLogout();
      } else {
        this.timer -= 1;
      }
    });
  }

  onLogout() {
    this.subscription.unsubscribe();
    this.authentication.logOut();
    this.idleService.stopWatching();
    this.dialogRef.close();
    this.router.navigate(['login']);
  }

  onCancel() {
    this.subscription.unsubscribe();
    this.idleService.resetTimer();
    this.dialogRef.close();
  }
}

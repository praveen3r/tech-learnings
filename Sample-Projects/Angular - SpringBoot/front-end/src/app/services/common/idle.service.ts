import { Injectable } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
import {
  fromEvent,
  merge,
  Observable,
  Subject,
  Subscription,
  timer,
} from 'rxjs';
import { environment } from './../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class IdleService {
  private idle: Observable<any> = new Observable();
  private timer: Subscription = new Subscription();
  private timeOutMilliSeconds: number = 1000;
  private idleSubscription: Subscription = new Subscription();
  public expired: Subject<boolean> = new Subject<boolean>();
  private idleTime = environment.idleTime;

  constructor(private modalService: BsModalService) {}

  public startWatching(): Observable<boolean> {
    this.idle = merge(
      fromEvent(document, 'mousemove'),
      fromEvent(document, 'click'),
      fromEvent(document, 'mousedown'),
      fromEvent(document, 'keypress'),
      fromEvent(document, 'DOMMouseScroll'),
      fromEvent(document, 'mousewheel'),
      fromEvent(document, 'touchmove'),
      fromEvent(document, 'MSPointerMove'),
      fromEvent(window, 'mousemove'),
      fromEvent(window, 'resize')
    );
    this.timeOutMilliSeconds = this.idleTime * this.timeOutMilliSeconds;
    this.idleSubscription = this.idle.subscribe((res) => {
      this.resetTimer();
    });
    this.startTimer();
    return this.expired;
  }

  private startTimer() {
    this.timer = timer(
      this.timeOutMilliSeconds,
      this.timeOutMilliSeconds
    ).subscribe((res) => {
      this.expired.next(true);
    });
  }
  public resetTimer() {
    this.timer.unsubscribe();
    this.startTimer();
  }
  public stopWatching() {
    this.timer.unsubscribe();
    this.idleSubscription.unsubscribe();
  }
}

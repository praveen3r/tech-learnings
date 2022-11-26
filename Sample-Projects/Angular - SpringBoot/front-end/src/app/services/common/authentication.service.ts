import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { User } from './../../model/User';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private user: User;
  public userDetails: Observable<User>;
  public loggedInChange: Observable<boolean>;
  private loggedInSubject = new Subject<boolean>();
  private userDetailsSubject = new Subject<User>();

  constructor() {
    // private tokenService: TokenService // private httpService: HttpService,
    /*this.loggedInChange = new Observable((observer: Observer<boolean>) {
      this.loggedInChangeObserver = observer;
    });*/
    this.loggedInChange = this.loggedInSubject.asObservable();
    this.userDetails = this.userDetailsSubject.asObservable();
  }

  public setIsLoggedIn(isLoggedInVal: boolean): void {
    this.loggedInSubject.next(isLoggedInVal);
  }

  public logout() {
    this.loggedInSubject.next(false);
    this.user = new User();
    this.userDetailsSubject.next(this.user);
    /*this.httpService.logout().subscribe(() => {
      this.tokenService.signOut();
    });*/
  }

  public setUserDetails(user: User): void {
    this.user = user;
    this.userDetailsSubject.next(user);
  }

  public getUserDetails(): User {
    return this.user;
  }
}

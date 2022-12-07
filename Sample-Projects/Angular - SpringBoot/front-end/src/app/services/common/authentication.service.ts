import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { User } from './../../model/User';
import { SecurityService } from './security.service';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private user: User;
  public userDetails: Observable<User>;
  public loggedInChange: Observable<boolean>;
  private loggedInSubject = new Subject<boolean>();
  private userDetailsSubject = new Subject<User>();

  constructor(
    private securityService: SecurityService,
    private tokenService: TokenService
  ) {
    this.loggedInChange = this.loggedInSubject.asObservable();
    this.userDetails = this.userDetailsSubject.asObservable();
  }

  public logIn(token: string): void {
    this.loggedInSubject.next(true);
    this.tokenService.saveToken(token);
  }

  public setIsLoggedIn(isLoggedInVal: boolean): void {
    this.loggedInSubject.next(isLoggedInVal);
  }

  public logOut() {
    this.securityService.logout().subscribe(() => {
      this.tokenService.signOut();
      this.loggedInSubject.next(false);
      this.user = new User();
      this.userDetailsSubject.next(this.user);
    });
  }

  public setUserDetails(user: User): void {
    this.user = user;
    this.userDetailsSubject.next(user);
  }

  public getUserDetails(): User {
    return this.user;
  }

  public isAuthenticated(): boolean {
    return this.tokenService.getToken() != null;
  }
}

import { User } from './../model/user';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private user:User = new User();
  private userSubject = new BehaviorSubject<User>(this.user);
  userData = this.userSubject.asObservable();
  constructor() { }

  login(loginUser:User) {
    this.user.emailId = loginUser.emailId;
    this.user.role = loginUser.role;
    this.user.isLoggedIn = true;
    this.userSubject.next(this.user);
  }

  logout(){
    this.user = new User();
    this.userSubject.next(this.user);
  }

  isAuthenticated():boolean {
    if(this.user.isLoggedIn) return true;
    return false;
  }

}

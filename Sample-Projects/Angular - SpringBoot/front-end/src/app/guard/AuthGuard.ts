import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from './../services/common/authentication.service';

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(
    public authentication: AuthenticationService,
    public router: Router
  ) {}

  canActivate(): boolean {
    if (!this.authentication.isAuthenticated()) {
      this.authentication.logOut();
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }
}

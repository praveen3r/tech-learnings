import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from './../../services/common/authentication.service';
import { SecurityService } from './../../services/common/security.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  public loginForm: FormGroup;
  public isSubmitted = false;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private authentication: AuthenticationService,
    private securityService: SecurityService
  ) {}

  public ngOnInit(): void {
    this.initForm();
  }

  private initForm = () => {
    this.loginForm = this.fb.group({
      userName: new FormControl(null, Validators.required),
      keyword: new FormControl(null, Validators.required),
    });
  };

  public onClickSubmit = () => {
    this.isSubmitted = true;
    if (this.loginForm.valid) {
      this.authenticate();
    }
  };

  private authenticate = () => {
    this.securityService.getToken().subscribe((response) => {
      console.log(response);
      this.authentication.setIsLoggedIn(true);
      this.router.navigate(['./home']);
    });
  };
}

import { HttpParams } from '@angular/common/http';
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
import { TokenService } from './../../services/common/token.service';
import { GeneralUtils } from './../../utils/GeneralUtils';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  public loginForm: FormGroup;
  public isSubmitted = false;
  public isError = false;
  public errorMsg = '';

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private authentication: AuthenticationService,
    private securityService: SecurityService,
    private tokenService: TokenService
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
    this.isSubmitted = false;
  };

  private authenticate = () => {
    this.clearError();
    this.processLogin();
  };

  private processLogin = () => {
    const userName = this.loginForm.controls.userName.value;
    const keyword = this.loginForm.controls.keyword.value;
    this.securityService.getToken(userName).subscribe((response) => {
      const key = response;
      let encrpted_keyword = GeneralUtils.getEncryptedData(keyword, key);
      encrpted_keyword = encrpted_keyword.replace(/\+/g, 'AB1');

      let queryParams = new HttpParams();
      queryParams = queryParams.append('secure_username', userName);
      queryParams = queryParams.append('secure_keyword', encrpted_keyword);

      this.securityService.authenticate(queryParams).subscribe(
        (response) => {
          if (response.body.success === true) {
            this.tokenService.saveToken(response.body.token);
            this.authentication.setIsLoggedIn(true);
            this.router.navigate(['./home']);
          } else {
            this.isError = true;
            this.errorMsg = 'error.login.invaliduser';
          }
        },
        (error) => {
          this.isError = true;
          if (error.status == '401') {
            this.errorMsg = 'error.login.invaliduser';
          } else if (error.status == '424') {
            this.errorMsg = 'error.login.exception';
          }
        }
      );
    });
  };

  public onClickReset = () => {
    this.initForm();
    this.clearError();
  };

  private clearError = () => {
    this.errorMsg = '';
    this.isError = false;
  };
}

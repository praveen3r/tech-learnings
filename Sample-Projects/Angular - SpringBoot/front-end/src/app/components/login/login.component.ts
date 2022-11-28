import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { GeneralUtils } from 'src/app/utils/GeneralUtils';
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
    const keyword = this.loginForm.controls.keyword.value;
    this.isSubmitted = true;
    if (this.loginForm.valid) {
      this.authenticate(keyword);
    }
  };

  private authenticate = (keyword: string) => {
    this.securityService.getToken().subscribe((response) => {
      const key = response;
      let encrpted_keyword = GeneralUtils.getEncryptedData(keyword, key);
      encrpted_keyword = encrpted_keyword.replace(/\+/g, 'AB1');

      const userName = this.loginForm.controls.userName.value;
      let queryParams = new HttpParams();
      queryParams = queryParams.append('secure_username', userName);
      queryParams = queryParams.append('secure_keyword', encrpted_keyword);

      this.securityService.authenticate(queryParams).subscribe((response) => {
        this.authentication.setIsLoggedIn(true);
        this.router.navigate(['./home']);
      });
    });
  };
}

import { LoginService } from './../../../services/login.service';
import { HttpService } from './../../../services/http.service';
import { User } from './../../../model/user';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public error:string = null;
  loginForm = this.fb.group({
    email: ['',Validators.required],
    password: ['',Validators.required]
  });
  constructor(private httpService:HttpService,
    private loginService:LoginService,
    private router:Router,
    private fb:FormBuilder) { }

  ngOnInit(): void {
  }

  login(){
    this.error = null;
    let username = this.loginForm.controls['email'].value;
    let password = this.loginForm.controls['password'].value;
    if(this.loginForm.controls['email'].invalid){
      this.error = "Email can't be empty";
    } else if(this.loginForm.controls['password'].invalid){
      this.error = "Password can't be empty";
    } else {
      let input="j_username="+username+'&j_password='+password;
      this.loginForm.controls['email'].setValue('');
      this.loginForm.controls['password'].setValue('');
      this.httpService.login(input).subscribe(result=>{
        if(result && result.role){
          let user:User = new User();
          user.emailId = username;
          user.role = result.role;
          this.loginService.login(user);
          if(user.role.toLowerCase()=='user'){
            this.router.navigate(['user']);
          } else {
            this.router.navigate(['admin']);
          }
        } else if(result && result.exception){
          this.error = result.exception;
        } else {
          this.error = "Login Failure!!!";
        }
      },error=>{
        if(error && error.error && error?.error.exception){
          this.error = error?.error.exception;
        } else {
          this.error = "Login Failure!!!";
        }
      });
    }
  }

}

import { LoginService } from './../../services/login.service';
import { HttpService } from './../../services/http.service';
import { User } from './../../model/user';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public error:string = null;
  public success:string = null;
  regForm = this.fb.group({
    email: ['',Validators.required],
    password: ['',Validators.required],
    confirmPwd: ['',Validators.required],
    name: ['',Validators.required]
  });
  constructor(private httpService:HttpService,
    private fb:FormBuilder) { }

  ngOnInit(): void {
  }

  register(){
    this.error = null;
    this.success = null;
    let email = this.regForm.controls['email'];
    let password = this.regForm.controls['password'];
    let name = this.regForm.controls['name'];
    let confPwd = this.regForm.controls['confirmPwd'];
    
    if(name.invalid){
      this.error = "Name can't be empty";
    } else if(email.invalid){
      this.error = "Email can't be empty";
    } else if(password.invalid){
      this.error = "Password can't be empty";
    } else if(confPwd.invalid){
      this.error = "Confirm Password can't be empty";
    } else if(password.value!=confPwd.value){
      this.error = "Password and Confirm Password are not matching!";
    } else {
      let user:User = new User();
      user.emailId = email.value;
      user.password = password.value;
      user.name = name.value;
      user.role = 'user';
      this.httpService.register(user).subscribe(result=>{
        email.setValue('');
        name.setValue('');
        password.setValue('');
        confPwd.setValue('');
        this.success = "Registration Successful!!!";
      },error=>{
        if(error.error){
          this.error = error.error;
        } else {
          this.error = "Registration Failure!!!";
        }
      });
    }
  }

}

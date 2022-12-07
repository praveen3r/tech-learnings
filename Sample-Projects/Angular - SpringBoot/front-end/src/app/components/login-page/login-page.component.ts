import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
// import { label } from '@angular/forms';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})
export class LoginPageComponent implements OnInit {
  // private loginForm: FormsModule;
  @Output() loginFlag = new EventEmitter<boolean>();
  pswd: String = '';
  userName: String = '';
  loginForm = new FormGroup({
    userName: new FormControl(),
    password: new FormControl(),
  });

  constructor(private router: Router) {}

  ngOnInit(): void {}

  submitAction() {
    // let loggedIn = true
    console.log('hii', this.loginForm.get('userName').value);
    this.loginFlag.emit(true);
    this.router.navigate(['home']);
  }
}

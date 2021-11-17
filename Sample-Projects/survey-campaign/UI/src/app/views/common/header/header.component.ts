import { HttpService } from './../../../services/http.service';
import { LoginService } from './../../../services/login.service';
import { User } from './../../../model/user';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user:User;
  constructor(private loginService:LoginService,
    private router:Router,
    private httpService:HttpService) { }

  ngOnInit(): void {
    this.loginService.userData.subscribe(user =>{
      this.user = user;
    });
  }

  logout() {
    this.httpService.logout().subscribe(res=>{
      this.loginService.logout();
      this.router.navigate(['/login']);
    });
  }

}

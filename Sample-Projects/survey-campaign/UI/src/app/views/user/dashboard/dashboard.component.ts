import { User } from './../../../model/user';
import { LoginService } from './../../../services/login.service';
import { HttpService } from './../../../services/http.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  user:User = new User();
  activeCampaign = 0;
  attendCampaign = 0;
  constructor(private http:HttpService,
    private loginService:LoginService) { }

  ngOnInit(): void {
    this.loginService.userData.subscribe(user=>{
      this.user = user;
    })
    this.getCompaigns();
  }

  getCompaigns() {
    this.http.getUserCompaign(this.user.emailId).subscribe(camp=>{
      if(camp && camp.length>0){
        this.activeCampaign=camp.length;
      }
    },err=>{
    });
    this.http.getUserAttendCompaign(this.user.emailId).subscribe(camp=>{
      if(camp && camp.length>0){
        this.attendCampaign=camp.length;
      }
    },err=>{
    });
  }

}

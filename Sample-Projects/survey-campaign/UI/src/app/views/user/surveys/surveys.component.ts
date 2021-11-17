import { LoginService } from './../../../services/login.service';
import { User } from './../../../model/user';
import { HttpService } from './../../../services/http.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-surveys',
  templateUrl: './surveys.component.html',
  styleUrls: ['./surveys.component.css']
})
export class SurveysComponent implements OnInit {

  compaigns = [];
  attendCampaigns = [];
  user:User = new User();
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
        this.compaigns=camp;
      }
    },err=>{
    });

    this.http.getUserAttendCompaign(this.user.emailId).subscribe(camp=>{
      if(camp && camp.length>0){
        this.attendCampaigns=camp;
      }
    },err=>{
    });
  }
}

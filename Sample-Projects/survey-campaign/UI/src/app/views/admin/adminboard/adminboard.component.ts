import { HttpService } from './../../../services/http.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adminboard',
  templateUrl: './adminboard.component.html',
  styleUrls: ['./adminboard.component.css']
})
export class AdminboardComponent implements OnInit {

  activeCampaigns = 0;
  activeUsers = 0;
  expiredCampaigns = 0;
  constructor(private http:HttpService) { }

  ngOnInit(): void {
    this.http.getCompaigns().subscribe(camp=>{
      if(camp && camp.length>0){
        camp.forEach(element => {
          let currentDate=new Date();
          currentDate.setHours(0);
          currentDate.setMinutes(0);
          currentDate.setSeconds(0);
          currentDate.setMilliseconds(0);
          let endDate=new Date(element.endDate);
          if(endDate>=currentDate){
            this.activeCampaigns += 1;
          }
        });
        this.expiredCampaigns = camp.length - this.activeCampaigns;
      }
    });
    this.noUser();
  }

  noUser(){
    this.http.noUsers().subscribe(result=>{
      if(result){
        console.log(result);
        this.activeUsers = result;
      }
    });
  }

}

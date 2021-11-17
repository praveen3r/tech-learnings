import { ToastrService } from 'ngx-toastr';
import { HttpService } from './../../../services/http.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-surveys',
  templateUrl: './surveys.component.html',
  styleUrls: ['./surveys.component.css']
})
export class SurveysComponent implements OnInit {

  compaigns = [];
  constructor(private http:HttpService,private toastr:ToastrService) { }

  ngOnInit(): void {
    this.getCompaigns();
  }

  getCompaigns() {
    this.http.getCompaigns().subscribe(camp=>{
      
      if(camp && camp.length>0){
        camp.forEach(element => {
          let currentDate=new Date();
          currentDate.setHours(0);
          currentDate.setMinutes(0);
          currentDate.setSeconds(0);
          currentDate.setMilliseconds(0);
          let endDate=new Date(element.endDate);
          if(endDate<currentDate){
            element.expired = true;
          }
        });
        this.compaigns = camp;
      }
    },err=>{
    });
  }

  removeCampaign(id:number){
    this.http.removeCompaign(id).subscribe(result=>{
      this.getCompaigns();
      this.toastr.success("Campaign removed successfully!!");
    },err=>{
      this.toastr.error("Something went wrong!!");
    });
  }

}

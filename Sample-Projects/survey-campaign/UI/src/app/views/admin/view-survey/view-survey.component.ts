import { ToastrService } from 'ngx-toastr';
import { HttpService } from './../../../services/http.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-view-survey',
  templateUrl: './view-survey.component.html',
  styleUrls: ['./view-survey.component.css']
})
export class ViewSurveyComponent implements OnInit {

  campaigns = [];
  campaignId = 0;
  campaign:any = {};
  constructor(private act:ActivatedRoute,private http:HttpService,private toastr:ToastrService,
    private router:Router) { 
    this.campaignId = this.act.snapshot.params.id;
  }

  ngOnInit(): void {
    this.getCompaigns();
  }

  getCompaigns() {
    this.http.getCompaign(this.campaignId).subscribe(camp=>{
      let currentDate=new Date();
      currentDate.setHours(0);
      currentDate.setMinutes(0);
      currentDate.setSeconds(0);
      currentDate.setMilliseconds(0);
      let endDate=new Date(camp.endDate);
      if(endDate<currentDate){
        camp.expired = true;
      }
      this.campaign = camp;
    },err=>{
    });
  }

  removeCampaign(id:number){
    this.http.removeCompaign(id).subscribe(result=>{
      this.router.navigate(['/admin/surveys']);
      this.toastr.success("Campaign removed successfully!!");
    },err=>{
      this.toastr.error("Something went wrong!!");
    });
  }

}

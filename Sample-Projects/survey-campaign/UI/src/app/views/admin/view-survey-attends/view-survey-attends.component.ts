import { ToastrService } from 'ngx-toastr';
import { HttpService } from './../../../services/http.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-survey-attends',
  templateUrl: './view-survey-attends.component.html',
  styleUrls: ['./view-survey-attends.component.css']
})
export class ViewSurveyAttendsComponent implements OnInit {

  qa = [];
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

  updateQuestion(i:number){
    this.qa = [];
    this.campaign.questionList.forEach((element,index:number) => {
      let answer = this.campaign.attemptList[i].answerList[index].answer;
      let obj = {
        question:element.question,
        answer:answer
      };
      this.qa.push(obj);
    });
  }

}

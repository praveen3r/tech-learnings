import { LoginService } from './../../../services/login.service';
import { FormBuilder, Validators, FormArray, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { HttpService } from './../../../services/http.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-submit-survey',
  templateUrl: './submit-survey.component.html',
  styleUrls: ['./submit-survey.component.css']
})
export class SubmitSurveyComponent implements OnInit {

  error = "";
  campaignId = 0;
  emailId = "";
  campaign:any = {};
  answerForm = this.fb.group({
    answers:this.fb.array([])
  });
  constructor(private act:ActivatedRoute,private http:HttpService,private toastr:ToastrService,
    private router:Router,private fb:FormBuilder,private loginService:LoginService) { 
    this.campaignId = this.act.snapshot.params.id;
  }

  ngOnInit(): void {
    this.loginService.userData.subscribe(user=>{
      this.emailId = user.emailId;
    });
    this.getCompaigns();
  }

  get f() { return this.answerForm.controls; }
  get t() { return this.f.answers as FormArray; }

  getCompaigns() {
    this.http.getCompaign(this.campaignId).subscribe(camp=>{
      this.campaign = camp;
      camp.questionList.forEach(qstn => {
        if(qstn.answerType=='Check Box'){
          this.t.push(this.fb.group({
            answer1: [''],
            answer2: [''],
            answer3: [''],
            answer4: ['']
          }));
        } else {
          this.t.push(this.fb.group({
            answer: ['', Validators.required]
          }));
        }
      });
      
    },err=>{
    });
  }

  onSubmit(){
    this.error = "";
    let ansObj = [];
    let answers = this.answerForm.controls.answers as FormArray;
    answers.controls.forEach((formGroup:FormGroup,index:number,array:[]) => {
      let answer = "";
      if(formGroup.controls['answer1']){
        let answer1=formGroup.controls.answer1.value;
        let answer2=formGroup.controls.answer2.value;
        let answer3=formGroup.controls.answer3.value;
        let answer4=formGroup.controls.answer4.value;
        if(answer1==''&&answer2==''&&answer3==''&&answer4==''){
          this.error = "Please select answer for Question no."+(index+1);
        } else {
          if(answer1==true) answer += this.campaign.questionList[index].choice1+",";
          if(answer2==true) answer += this.campaign.questionList[index].choice2+",";
          if(answer3==true) answer += this.campaign.questionList[index].choice3+",";
          if(answer4==true) answer += this.campaign.questionList[index].choice4+",";
          answer = answer.substring(0,answer.length-1);
        }
      } else {
        answer = formGroup.controls.answer.value;
      }
      let obj={
        answer:answer,
        questionId:this.campaign.questionList[index].questionId,
      };
      ansObj.push(obj);
      if((index==array.length-1) && this.error==""){
        let input = {
          emailId:this.emailId,
          campaignId:this.campaignId,
          answerList:ansObj
        };
        this.http.addAnswers(input).subscribe(result=>{
          this.toastr.success("Survey Submitted Successfully!!");
          this.router.navigate(['/user/surveys']);
        },error=>{
          this.toastr.error("Something went wrong!");
        });
  
      }
    });
  }
}

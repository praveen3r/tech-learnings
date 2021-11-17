import { Router } from '@angular/router';
import { HttpService } from './../../../services/http.service';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-add-survey',
  templateUrl: './add-survey.component.html',
  styleUrls: ['./add-survey.component.css']
})
export class AddSurveyComponent implements OnInit {

  error = "";
  numberOfQstns:number = 0;
  submitted:boolean = false;
  qstnForm = this.fb.group({
    title:['',Validators.required],
    startDate:['',Validators.required],
    endDate:['',Validators.required],
    qstns:this.fb.array([])
  });
  constructor(private fb:FormBuilder,private http:HttpService,
    private router:Router,private toastr:ToastrService) { }

  ngOnInit(): void {
  }

  get f() { return this.qstnForm.controls; }
  get t() { return this.f.qstns as FormArray; }

  addNew(){
    this.numberOfQstns += 1;
    this.t.push(this.fb.group({
      qstn: ['', Validators.required],
      answerType: ['', Validators.required],
      fieldType: [''],
      choice1: [''],
      choice2: [''],
      choice3: [''],
      choice4: ['']
    }));
  }

  onSubmit(){
    this.error = "";
    this.submitted = true;
    if(this.qstnForm.valid){
      if(this.numberOfQstns==0) {
        this.error="At least 1 Question should be there!!!"
      } else {
        let qstnList = [];
        let qstns = this.qstnForm.controls.qstns as FormArray;
        qstns.controls.forEach((formGroup:FormGroup) => {
          let question = formGroup.controls.qstn.value;
          let answerType = formGroup.controls.answerType.value;
          let fieldType = formGroup.controls.fieldType.value;
          let choice1 = formGroup.controls.choice1.value;
          let choice2 = formGroup.controls.choice2.value;
          let choice3 = formGroup.controls.choice3.value;
          let choice4 = formGroup.controls.choice4.value;
          if(answerType=='Single Line' && fieldType==''){
            this.error="Field Type can't be empty";
          }
          else if((answerType=='Radio Button'||answerType=='Check Box')&&(choice1==''||choice2=='')){
            this.error="Minimum 2 choice should be there";
          } else {
            let qstn={
              question:question,
              answerType:answerType,
              fieldType:fieldType,
              choice1:choice1,
              choice2:choice2,
              choice3:choice3,
              choice4:choice4
            };
            qstnList.push(qstn);
          }
        });
        if(!this.error){
          let object = {
            title:this.qstnForm.controls.title.value,
            startDate:this.qstnForm.controls.startDate.value,
            endDate:this.qstnForm.controls.endDate.value,
            questionList:qstnList
          };
          console.log(object);
          this.http.addCampaign(object).subscribe(result=>{
            this.toastr.success("Campaign Added Successfully!!");
            this.router.navigate(['/admin/surveys']);
          },err=>{
            this.error="Something went wrong!!";
          })
        }
      }
    }
  }

  removeQstn(i:number){
    this.numberOfQstns -= 1;
    this.t.removeAt(i);
  }

}

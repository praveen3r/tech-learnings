import { SubmitSurveyComponent } from './submit-survey/submit-survey.component';
import { SurveysComponent } from './surveys/surveys.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path:'',
    component:DashboardComponent
  },
  {
    path:'surveys',
    component:SurveysComponent
  },
  {
    path:'participateSurvey/:id',
    component:SubmitSurveyComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }

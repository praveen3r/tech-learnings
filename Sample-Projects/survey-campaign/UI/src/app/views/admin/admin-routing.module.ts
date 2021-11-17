import { LoginGuard } from './../../authguard/login.guard';
import { AddSurveyComponent } from './add-survey/add-survey.component';
import { ViewSurveyComponent } from './view-survey/view-survey.component';
import { UsersComponent } from './users/users.component';
import { SurveysComponent } from './surveys/surveys.component';
import { AdminboardComponent } from './adminboard/adminboard.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewSurveyAttendsComponent } from './view-survey-attends/view-survey-attends.component';


const routes: Routes = [
  {
    path:'',
    component:AdminboardComponent
  },
  {
    path:'surveys',
    component:SurveysComponent,
    canActivate:[LoginGuard]
  },
  {
    path:'users',
    component:UsersComponent
  },
  {
    path:'viewSurvey/:id',
    component:ViewSurveyComponent
  },
  {
    path:'viewSurveyAttends/:id',
    component:ViewSurveyAttendsComponent
  },
  {
    path:'addSurvey',
    component:AddSurveyComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }

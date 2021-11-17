import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { LoginGuard } from './../../authguard/login.guard';
import { AdminRoutingModule } from './admin-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminboardComponent } from './adminboard/adminboard.component';
import { SurveysComponent } from './surveys/surveys.component';
import { UsersComponent } from './users/users.component';
import { ViewSurveyComponent } from './view-survey/view-survey.component';
import { ViewSurveyAttendsComponent } from './view-survey-attends/view-survey-attends.component';
import { AddSurveyComponent } from './add-survey/add-survey.component';



@NgModule({
  declarations: [AdminboardComponent, SurveysComponent, UsersComponent, ViewSurveyComponent, ViewSurveyAttendsComponent, AddSurveyComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers:[LoginGuard]
})
export class AdminModule { }

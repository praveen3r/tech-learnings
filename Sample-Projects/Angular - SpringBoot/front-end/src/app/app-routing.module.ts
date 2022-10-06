import { NgModule } from '@angular/core';
// import { CommonModule } from '@angular/common';
import { RouterModule,Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { ObjectiveComponent } from './objective/objective.component';
import { JobInfoComponent } from './job-info/job-info.component';
import { HobbiesComponent } from './hobbies/hobbies.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';

const routes: Routes = [
                        {path:'home',component: HomeComponent},
                        {path:'Objective', component: ObjectiveComponent},
                        {path: 'Job Info', component: JobInfoComponent},
                        {path: 'Hobbies', component: HobbiesComponent},
                        {path: 'Contact', component: ContactComponent},
                        {path: 'About Me', component: AboutComponent}
                      ];

@NgModule({
  declarations: [],
  // imports: [
  //   CommonModule
  // ]
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

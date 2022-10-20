import { NgModule } from '@angular/core';
// import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { CourseSearchComponent } from './components/course-search/course-search.component';
import { CourseComponent } from './components/course/courses.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'Course', component: CourseComponent },
  { path: 'Search', component: CourseSearchComponent },
  { path: 'Contact', component: ContactComponent },
  { path: 'About Me', component: AboutComponent },
];

@NgModule({
  declarations: [],
  // imports: [
  //   CommonModule
  // ]
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

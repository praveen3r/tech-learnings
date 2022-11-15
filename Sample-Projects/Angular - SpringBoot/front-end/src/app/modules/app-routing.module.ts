import { NgModule } from '@angular/core';
// import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from '../components/about/about.component';
import { ContactComponent } from '../components/contact/contact.component';
import { CourseSearchComponent } from '../components/course-search/course-search.component';
import { CourseGridExpandableRowComponent } from '../components/course/course-grid-expand-row.component';
import { CourseGridComponent } from '../components/course/course-grid.component';
import { HomeComponent } from '../components/home/home.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  //{ path: 'course', component: CourseComponent },
  { path: 'course', component: CourseGridComponent },
  { path: 'course-expand-row', component: CourseGridExpandableRowComponent },
  { path: 'course-search', component: CourseSearchComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'about', component: AboutComponent },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

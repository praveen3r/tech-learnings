import { NgModule } from '@angular/core';
// import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CourseSearchComponent } from '../components/course-search/course-search.component';
import { CourseGridExpandableRowComponent } from '../components/course/course-grid-expand-row.component';
import { CourseGridServerPaginationComponent } from '../components/course/course-grid-server-pagination.component';
import { CourseGridComponent } from '../components/course/course-grid.component';
import { HomeComponent } from '../components/home/home.component';
import { LoginComponent } from '../components/login/login.component';
import { AuthGuard } from './../guard/AuthGuard';

const routes: Routes = [
  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
  //{ path: 'course', component: CourseComponent },
  { path: 'course', component: CourseGridComponent, canActivate: [AuthGuard] },
  {
    path: 'course-expand-row',
    component: CourseGridExpandableRowComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'course-search',
    component: CourseSearchComponent,
    canActivate: [AuthGuard],
  },
  {
    path: 'course-server-pagination',
    component: CourseGridServerPaginationComponent,
    canActivate: [AuthGuard],
  },
  { path: 'login', component: LoginComponent },
  { path: '**', component: LoginComponent },
];

@NgModule({
  declarations: [],
  providers: [AuthGuard],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

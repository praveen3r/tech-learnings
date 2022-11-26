import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import {
  BrowserAnimationsModule,
  NoopAnimationsModule,
} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { CourseSearchComponent } from './components/course-search/course-search.component';
import { CourseGridExpandableRowComponent } from './components/course/course-grid-expand-row.component';
import { CourseGridComponent } from './components/course/course-grid.component';
import { CourseInputComponent } from './components/course/course-input.component';
import { CourseComponent } from './components/course/courses.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/layout/header.component';
// import { LoginPageComponent } from './components/login-page/login-page.component';
import { LoginComponent } from './components/login/login.component';
import { InputCharDirective } from './directives/input.char.directive';
import { CustomInterceptor } from './interceptor/custom-interceptor';
import { ConfirmMessageComponent } from './lib/modal/confirm/confirm-message.component';
import { MessageComponent } from './lib/modal/message/message.component';
import { AppRoutingModule } from './modules/app-routing.module';
import { MaterialModule } from './modules/material.module';
import { SharedModule } from './modules/shared.module';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    CourseComponent,
    CourseGridComponent,
    CourseGridExpandableRowComponent,
    CourseSearchComponent,
    ConfirmMessageComponent,
    CourseInputComponent,
    HeaderComponent,
    MessageComponent,
    CourseGridComponent,
    InputCharDirective,
  ],
  imports: [
    BrowserModule,
    NoopAnimationsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    MaterialModule,
    SharedModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: CustomInterceptor,
      multi: true,
    },
  ],
  exports: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

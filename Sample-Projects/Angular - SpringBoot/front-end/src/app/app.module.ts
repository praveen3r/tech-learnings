import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {
  HttpClient,
  HttpClientModule,
  HTTP_INTERCEPTORS,
} from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTooltipModule } from '@angular/material/tooltip';
import {
  BrowserAnimationsModule,
  NoopAnimationsModule,
} from '@angular/platform-browser/animations';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { ModalModule } from 'ngx-bootstrap/modal';
import { NgxSpinnerModule } from 'ngx-spinner';
import { AppComponent } from './app.component';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { CourseSearchComponent } from './components/course-search/course-search.component';
import { AddCourseComponent } from './components/course/add-course.component';
import { CourseComponent } from './components/course/courses.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/layout/header.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { CustomInterceptor } from './interceptor/custom-interceptor';
import { DialogBodyComponent } from './lib/dialog-body/dialog-body.component';
import { AppRoutingModule } from './modules/app-routing.module';

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    HomeComponent,
    CourseComponent,
    CourseSearchComponent,
    AboutComponent,
    ContactComponent,
    DialogBodyComponent,
    AddCourseComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    MatCardModule,
    NoopAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatIconModule,
    MatSidenavModule,
    MatExpansionModule,
    MatDialogModule,
    MatTooltipModule,
    BrowserAnimationsModule,
    HttpClientModule,
    NgxSpinnerModule,
    ModalModule.forRoot(),
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient],
      },
      defaultLanguage: 'en',
    }),
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: CustomInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}

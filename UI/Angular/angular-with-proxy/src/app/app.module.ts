import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RootModule, UIRouterModule, Transition } from '@uirouter/angular';
import { LoginComponent } from './scripts/components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpReqInterceptor } from './scripts/components/interceptor/http-interceptor';
import { HttpErrorInterceptor } from './scripts/components/interceptor/http-error-interceptor';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { NgbDateCustomParserFormatter } from './scripts/components/common/NgbDateCustomParserFormatter';
import { AngularFontAwesomeModule } from 'angular-font-awesome';


const rootModule: RootModule = {
  states: [
    {
    name: "login",
    url: "/",
    component: LoginComponent
    },
    
  ],
  otherwise: "/"
};

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    UIRouterModule.forRoot(rootModule),
    HttpClientModule,
    NgbModule,
    AngularFontAwesomeModule,
    ReactiveFormsModule
  ],
  exports: [UIRouterModule],
  entryComponents: [
],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpReqInterceptor,
    multi: true
  },{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true
  },{
    provide: NgbDateParserFormatter, 
    useClass: NgbDateCustomParserFormatter}],
  bootstrap: [AppComponent]
})
export class AppModule { }

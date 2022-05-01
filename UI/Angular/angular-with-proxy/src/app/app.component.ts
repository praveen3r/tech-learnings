import { Component, OnInit } from '@angular/core';
import { StateService } from '@uirouter/angular';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./css/app.component.css']
})
export class AppComponent implements OnInit{
  title = 'demoproj';
  //authData:any = {};
  authData:any = {};

    
  constructor(private state: StateService) { 
    this.authData.isLoggedIn = false;
  }

  ngOnInit() {
     

    
    }

    

  
}

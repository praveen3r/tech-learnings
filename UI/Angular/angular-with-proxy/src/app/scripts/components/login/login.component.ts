import { Component, OnInit } from '@angular/core';
import { StateService } from '@uirouter/angular';
import { NgForm } from '@angular/forms'
import { HttpService } from '../../services/http.service';

@Component({
  templateUrl: './login.component.html',
})
export class LoginComponent implements OnInit {

  data:any;
  
    

  constructor(private httpService: HttpService) { 
  
  }

  ngOnInit() {
    this.httpService.getData().subscribe(response => {
      this.data = response;
    });
  }

  

}

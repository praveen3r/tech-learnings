import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/services/http.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users = [];

  constructor(private http:HttpService) { }

  ngOnInit(): void {
   this.http.getUserList().subscribe(response => {
    this.users = response;
   })
  }

}

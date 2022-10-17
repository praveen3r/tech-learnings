import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DialogBodyComponent } from './lib/dialog-body/dialog-body.component';
import { MatTooltip } from '@angular/material/tooltip';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isLoggedIn: boolean = false
  list: Array<String> = ["Objective","Job Info",'Hobbies',"About Me","Contact"]

  constructor(private router:Router, public dialog: MatDialog){};
  
  title = 'my-learning-app';

  check(event){
    this.isLoggedIn = event
  }


  logout(): void {
    this.router.navigate([]);
    // const dialogRef = this.dialog.open(DialogBodyComponent, {
    //   width: '250px',
    // });

    // dialogRef.afterClosed().subscribe(result => {
    //   this.isLoggedIn = false;
    //   // this.router.navigate([])
    // });
  }

}

import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  isLoggedIn: boolean = false;
  list: Array<String> = ['Course', 'Search', 'About Me', 'Contact'];

  constructor(private router: Router, public dialog: MatDialog) {}

  title = 'my-learning-app';

  check(event) {
    console.log('came', event);
    this.isLoggedIn = event;
  }

  logout(): void {
    this.isLoggedIn = false;
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

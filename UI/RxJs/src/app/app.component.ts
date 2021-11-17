import { Component, OnInit } from '@angular/core';
//import { Create } from './operators/creation/Create';
//import { Subscribe } from './subscription/Subscribe';
//import { SwitchMap } from './operators/transformation/SwitchMap';
//import { ForkJoin } from './operators/combination/ForkJoin';
//import { Filter } from './operators/filtering/Filter';

import { TestBehaviourSubject } from './subject/TestBehaviourSubject';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'RxJs';

  ngOnInit() {

    TestBehaviourSubject.processBehaviourSubject1();

  }
}

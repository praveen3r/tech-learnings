import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSurveyAttendsComponent } from './view-survey-attends.component';

describe('ViewSurveyAttendsComponent', () => {
  let component: ViewSurveyAttendsComponent;
  let fixture: ComponentFixture<ViewSurveyAttendsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewSurveyAttendsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewSurveyAttendsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

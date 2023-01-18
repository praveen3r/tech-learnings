import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { MatDatepickerInput } from '@angular/material/datepicker';
import { Course } from '../../entity/Course';
import { Constants } from '../../utils/Constants';
import { CourseService } from './../../services/course/course.service';
import { DateUtil } from './../../utils/DateUtil';

@Component({
  templateUrl: './course-search.component.html',
  styleUrls: ['./course-search.component.css'],
})
export class CourseSearchComponent implements OnInit {
  public courseSearchForm: FormGroup;
  public startDate: Date;
  public endDate: Date;
  public isSearchResultsDisplay = false;
  public courses: Course[] = [];
  public isSubmitted = false;

  constructor(private fb: FormBuilder, private courseService: CourseService) {
    this.startDate = DateUtil.getSubtractedDate(new Date(), 8);
    this.endDate = DateUtil.getTodayDate();
  }

  ngOnInit(): void {
    this.initForm();
  }

  private initForm = () => {
    this.courseSearchForm = this.fb.group({
      name: new FormControl('', [Validators.required, Validators.minLength(1)]),
      startDate: new FormControl(
        { value: this.startDate, disabled: true },
        Validators.required
      ),
      endDate: new FormControl(
        { value: this.endDate, disabled: true },
        Validators.required
      ),
    });
    this.courseSearchForm.get('startDate').disable();
  };

  public handleStartDateChange = (event: MatDatepickerInput<Date>) => {
    const value = event.value;
    this.startDate = value;
  };

  public handleEndDateChange = (event: MatDatepickerInput<Date>) => {
    const value = event.value;
    this.endDate = value;
  };

  public onClickSearch = () => {
    this.isSubmitted = true;
    if (this.courseSearchForm.valid) {
      const name = this.courseSearchForm.controls.name.value;
      const startDate = DateUtil.formatDate(
        this.courseSearchForm.controls.startDate.value,
        Constants.DATEFORMAT_DDMMYYYY
      );
      const endDate = DateUtil.formatDate(
        this.courseSearchForm.controls.endDate.value,
        Constants.DATEFORMAT_DDMMYYYY
      );

      this.processSearchData(name, startDate, endDate);
    }
  };

  private processSearchData = (...arrgs: string[]) => {
    let queryParams = new HttpParams();
    queryParams = queryParams.append('name', arrgs[0]);
    queryParams = queryParams.append('startDate', arrgs[1]);
    queryParams = queryParams.append('endDate', arrgs[2]);
    this.courseService.searchCourse(queryParams).subscribe((response) => {
      this.isSearchResultsDisplay = true;
      if (response.courses) {
        this.courses = response.courses;
      }
    });
  };

  public onClickReset = () => {
    this.isSearchResultsDisplay = false;
    this.courses = [];
    this.isSubmitted = false;
  };
}

import { Component, OnInit } from '@angular/core';
import { Course } from '../../model/Course';
import { CourseService } from './course.service';

@Component({
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css'],
})
export class CourseComponent implements OnInit {
  courses: Course[];

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.courseService.getCourses().subscribe((response) => {
      if (response.courses) {
        this.courses = response.courses;
      }
    });
  }
}

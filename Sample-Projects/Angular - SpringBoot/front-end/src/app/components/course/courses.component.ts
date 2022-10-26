import { Component, OnInit } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { Course } from '../../model/Course';
import { CourseService } from '../../services/course/course.service';
import { AddCourseComponent } from './add-course.component';

@Component({
  templateUrl: './course.component.html',
})
export class CourseComponent implements OnInit {
  courses: Course[];
  private modalRef: BsModalRef;

  constructor(
    private courseService: CourseService,
    private modalService: BsModalService
  ) {}

  ngOnInit(): void {
    this.courseService.getCourses().subscribe((response) => {
      if (response.courses) {
        this.courses = response.courses;
      }
    });
  }

  onClickAdd = () => {
    this.modalRef = this.modalService.show(AddCourseComponent, {
      class: 'modal-lg',
    });
  };
}

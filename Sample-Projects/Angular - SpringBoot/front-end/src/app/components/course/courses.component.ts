import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BsModalService } from 'ngx-bootstrap/modal';
import { ConfirmMessageComponent } from '../../lib/modal/confirm/confirm-message.component';
import { Course } from '../../model/Course';
import { CourseService } from '../../services/course/course.service';
import { MessageService } from './../../services/common/message.service';
import { Constants } from './../../utils/Constants';
import { CourseInputComponent } from './course-input.component';

@Component({
  templateUrl: 'course.component.html',
})
export class CourseComponent implements OnInit {
  public isLoadingComplete = false;
  public courses: Course[] = [];

  constructor(
    private courseService: CourseService,
    private modalService: BsModalService,
    private dialogService: MatDialog,
    private msgService: MessageService
  ) {}

  public ngOnInit(): void {
    this.fetchCourses();
  }

  private fetchCourses = () => {
    this.courseService.getCourses().subscribe((response) => {
      this.isLoadingComplete = true;
      if (response.courses) {
        this.courses = response.courses;
      }
    });
  };

  public onClickAdd = () => {
    const course = new Course();
    const initialState = {
      isAdd: true,
      course,
    };
    const modalRef = this.modalService.show(CourseInputComponent, {
      class: 'modal-md',
      initialState,
    });

    modalRef.content.onClose.subscribe((result: boolean) => {
      if (result) {
        this.fetchCourses();
      }
    });
  };

  public onClickEdit = (course: Course) => {
    const initialState = {
      isAdd: false,
      course,
    };
    const modalRef = this.modalService.show(CourseInputComponent, {
      class: 'modal-md',
      initialState,
    });

    modalRef.content.onClose.subscribe((result: boolean) => {
      if (result) {
        this.fetchCourses();
      }
    });
  };

  public onClickDelete = (course: Course) => {
    const dialogRef = this.dialogService.open(ConfirmMessageComponent, {
      data: course.name,
    });
    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.deleteCourse(course.id);
      }
    });
  };

  private deleteCourse = (id: number) => {
    this.courseService
      .deleteCourse(id)
      .subscribe((response: HttpResponse<void>) => {
        if (response.status == Constants.HTTP_DELETE_SUCCESS_CODE) {
          this.msgService.displayDeleteSuccessMsg('menu.course');
          this.fetchCourses();
        }
      });
  };
}

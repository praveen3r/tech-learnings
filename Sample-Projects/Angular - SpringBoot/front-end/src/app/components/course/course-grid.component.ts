import { HttpResponse } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { BsModalService } from 'ngx-bootstrap/modal';
import { Constants } from 'src/app/utils/Constants';
import { ConfirmMessageComponent } from '../../lib/modal/confirm/confirm-message.component';
import { Course } from '../../model/Course';
import { CourseService } from '../../services/course/course.service';
import { MessageService } from './../../services/common/message.service';
import { CourseInputComponent } from './course-input.component';

@Component({
  templateUrl: 'course-grid.component.html',
})
export class CourseGridComponent implements OnInit {
  public isLoadingComplete = false;
  public pageSize = Constants.PAGE_SIZE;
  public pageSizeOptions = Constants.PAGE_SIZE_OPTIONS;
  public displayedColumns = ['name', 'type', 'author', 'actions'];
  public courseDataSource: MatTableDataSource<Course>;
  public emptyDataSource: MatTableDataSource<{ empty: string }>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) courseSort: MatSort;

  constructor(
    private courseService: CourseService,
    private modalService: BsModalService,
    private dialogService: MatDialog,
    private msgService: MessageService
  ) {
    this.courseDataSource = new MatTableDataSource<Course>([]);
    this.emptyDataSource = new MatTableDataSource([{ empty: 'row' }]);
  }

  public ngOnInit(): void {
    this.fetchCourses();
  }

  public ngAfterViewInit() {
    this.courseDataSource.paginator = this.paginator;
    // this.courseSort.active = 'name';
    //this.courseSort.direction = 'desc';
    //this.courseSort.disableClear = false;
    this.courseDataSource.sort = this.courseSort;
  }

  private fetchCourses = () => {
    this.courseService.getCourses().subscribe((response) => {
      this.isLoadingComplete = true;
      if (response.courses) {
        this.courseDataSource.data = response.courses;
      }
    });
  };

  public applyFilter = (event: Event) => {
    const filterValue = (event.target as HTMLInputElement).value;
    this.courseDataSource.filter = filterValue.trim().toLowerCase();
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

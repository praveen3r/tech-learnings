import {
  animate,
  state,
  style,
  transition,
  trigger,
} from '@angular/animations';
import { HttpResponse } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { BsModalService } from 'ngx-bootstrap/modal';
import { Constants } from 'src/app/utils/Constants';
import { Course } from '../../entity/Course';
import { ConfirmMessageComponent } from '../../lib/modal/confirm/confirm-message.component';
import { CourseService } from '../../services/course/course.service';
import { MessageService } from './../../services/common/message.service';
import { CourseInputComponent } from './course-input.component';

@Component({
  styleUrls: ['course-grid-expand-row.scss'],
  templateUrl: 'course-grid-expand-row.component.html',
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition(
        'expanded <=> collapsed',
        animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')
      ),
    ]),
  ],
})
export class CourseGridExpandableRowComponent implements OnInit {
  public isLoadingComplete = false;
  public pageSize = Constants.PAGE_SIZE;
  public pageSizeOptions = Constants.PAGE_SIZE_OPTIONS;
  public displayedColumns = ['Name', 'Type', 'Author', 'actions'];
  public courseDataSource: MatTableDataSource<Course>;
  public emptyDataSource: MatTableDataSource<{ empty: string }>;

  @ViewChild('paginator') paginator: MatPaginator;

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

  private fetchCourses = () => {
    this.courseService.getCourses().subscribe((response) => {
      this.isLoadingComplete = true;
      if (response.courses) {
        this.courseDataSource.data = response.courses;
        if (this.courseDataSource.data.length > 0) {
          this.courseDataSource.paginator = this.paginator;
        }
      }
    });
  };

  public toggleRow(element: { expanded: boolean }) {
    element.expanded = !element.expanded;
  }

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

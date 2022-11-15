import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Constants } from 'src/app/utils/Constants';
import { Course } from '../../model/Course';
import { CourseService } from '../../services/course/course.service';

@Component({
  templateUrl: './course-grid-expand-row.component.html',
})
export class CourseGridExpandableRowComponent implements OnInit {
  public isLoadingComplete = false;
  public pageSize = Constants.PAGE_SIZE;
  public pageSizeOptions = Constants.PAGE_SIZE_OPTIONS;
  public displayedColumns = ['Name', 'Type', 'Author'];
  public courseDataSource: MatTableDataSource<Course>;
  public emptyDataSource: MatTableDataSource<{ empty: string }>;

  @ViewChild('paginator') paginator: MatPaginator;

  constructor(private courseService: CourseService) {
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
}

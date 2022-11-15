import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Constants } from 'src/app/utils/Constants';
import { Course } from '../../model/Course';
import { CourseService } from '../../services/course/course.service';

@Component({
  templateUrl: './course-grid.component.html',
})
export class CourseGridComponent implements OnInit {
  public isLoadingComplete = false;
  public pageSize = Constants.PAGE_SIZE;
  public pageSizeOptions = Constants.PAGE_SIZE_OPTIONS;
  public displayedColumns = ['name', 'type', 'author'];
  public courseDataSource: MatTableDataSource<Course>;
  public emptyDataSource: MatTableDataSource<{ empty: string }>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) courseSort: MatSort;

  constructor(private courseService: CourseService) {
    this.courseDataSource = new MatTableDataSource<Course>([]);
    this.emptyDataSource = new MatTableDataSource([{ empty: 'row' }]);
  }

  public ngOnInit(): void {
    this.fetchCourses();
  }

  ngAfterViewInit() {
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
}

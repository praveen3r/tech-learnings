import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from 'src/app/entity/Course';
import { url } from '../../conf/_url';
import { CourseType, CourseTypeMasterRes } from '../../types/response-types';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  constructor(private http: HttpClient) {}

  getCourses(): Observable<CourseType> {
    return this.http.get<CourseType>(url.COURSE_SERVICE);
  }

  addCourses(course: Course): Observable<Object> {
    return this.http.post(url.COURSE_MODIFY_SERVICE, course, {
      observe: 'response',
    });
  }

  updateCourse(course: Course, id: number): Observable<Object> {
    return this.http.put(`${url.COURSE_MODIFY_SERVICE}/${id}`, course, {
      observe: 'response',
    });
  }

  deleteCourse(id: number): Observable<Object> {
    return this.http.delete(`${url.COURSE_MODIFY_SERVICE}/${id}`, {
      observe: 'response',
    });
  }

  searchCourse(params: HttpParams): Observable<CourseType> {
    return this.http.get<CourseType>(`${url.COURSE_SEARCH_SERVICE}`, {
      params,
    });
  }

  getCourseTypes(): Observable<CourseTypeMasterRes> {
    return this.http.get<CourseTypeMasterRes>(url.COURSE_TYPES_SERVICE);
  }
}

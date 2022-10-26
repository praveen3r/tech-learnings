import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { url } from '../../conf/_url';
import { CourseType } from '../../types/response-types';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  constructor(private http: HttpClient) {}

  getCourses(data?: string): Observable<CourseType> {
    return this.http.get<CourseType>(url.COURSE_SERVICE);
  }
}

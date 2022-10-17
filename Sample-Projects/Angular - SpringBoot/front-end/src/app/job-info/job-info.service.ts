
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  export class JobInfoService {

    constructor(private http: HttpClient) { }

    getCourses(data?: string): Observable<any> {
        return this.http.get<any>('http://localhost:8080/v1/users/');
      }

  }

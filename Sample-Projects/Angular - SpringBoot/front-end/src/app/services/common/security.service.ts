import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { url } from '../../conf/_url';

@Injectable({
  providedIn: 'root',
})
export class SecurityService {
  constructor(private http: HttpClient) {}

  getToken(id: string): Observable<string> {
    return this.http.get(`${url.TOKEN_SERVICE}/${id}`, {
      headers: { Accept: 'text/plain' },
      responseType: 'text',
    });
  }

  authenticate(params: HttpParams): Observable<any> {
    return this.http.post(url.AUTH_SERVICE, params, {
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      observe: 'response',
    });
  }

  logout(): Observable<any> {
    return this.http.post<any>(url.LOGOUT_SERVICE, {});
  }
}

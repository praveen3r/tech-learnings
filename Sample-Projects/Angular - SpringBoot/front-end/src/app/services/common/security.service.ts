import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { url } from '../../conf/_url';

@Injectable({
  providedIn: 'root',
})
export class SecurityService {
  constructor(private http: HttpClient) {}

  getToken(data?: string): Observable<string> {
    if (data) {
      return this.http.get(url.TOKEN_SERVICE + data, {
        headers: { Accept: 'text/plain' },
        responseType: 'text',
      });
    } else {
      return this.http.get(url.TOKEN_SERVICE, {
        headers: { Accept: 'text/plain' },
        responseType: 'text',
      });
    }
  }
}

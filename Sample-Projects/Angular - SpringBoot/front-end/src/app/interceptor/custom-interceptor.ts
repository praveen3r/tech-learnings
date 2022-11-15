import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { NgxSpinnerService } from 'ngx-spinner';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { MessageComponent } from '../../app/lib/modal/message/message.component';
import { TokenService } from '../services/common/token.service';

@Injectable()
export class CustomInterceptor implements HttpInterceptor {
  private totalRequests = 0;
  bsModalRef: BsModalRef;

  constructor(
    private spinner: NgxSpinnerService,
    private dialogService: MatDialog,
    private tokenService: TokenService
  ) {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    this.totalRequests++;
    let customReq = request;
    if (this.tokenService.getToken() != null) {
      let headers = request.headers;
      headers = headers.set(
        'Authorization',
        'Bearer ' + this.tokenService.getToken()
      );
      if (request.responseType != null && request.responseType != 'text') {
        headers = headers.set('Accept', 'application/json');
      }
      customReq = request.clone({ headers: headers });
    }
    this.spinner.show();
    return next.handle(customReq).pipe(
      tap((res) => {
        if (res instanceof HttpResponse) {
          this.decreaseRequests();
        }
      }),
      catchError((err) => {
        this.decreaseRequests();
        this.processError(err);
        throw err;
      })
    );
  }

  private processError = (err) => {
    let errorMsg: string;

    if (err && err.error) {
      const statusCode: number = err.status;
      if (statusCode <= 0) {
        errorMsg = 'error.connectionLost';
      } else {
        errorMsg = 'error.sysError';
      }
      const dialogRef = this.dialogService.open(MessageComponent, {
        data: errorMsg,
      });
    }
  };

  private decreaseRequests = () => {
    this.totalRequests--;
    if (this.totalRequests === 0) {
      this.spinner.hide();
    }
  };
}

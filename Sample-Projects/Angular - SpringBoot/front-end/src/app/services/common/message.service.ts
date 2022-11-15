import { Injectable } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  constructor(
    private toastr: ToastrService,
    private translate: TranslateService
  ) {}

  public displayAddSuccessMsg = (key: string) => {
    this.toastr.success(
      this.translate.instant('addMsg', {
        key: this.translate.instant(key),
      })
    );
  };

  public displayUpdateSuccessMsg = (key: string) => {
    this.toastr.success(
      this.translate.instant('updateMsg', {
        key: this.translate.instant(key),
      })
    );
  };

  public displayDeleteSuccessMsg = (key: string) => {
    this.toastr.success(
      this.translate.instant('deleteMsg', {
        key: this.translate.instant(key),
      })
    );
  };
}

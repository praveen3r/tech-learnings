import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TranslateService } from '@ngx-translate/core';

@Component({
  templateUrl: './message.component.html',
})
export class MessageComponent {
  constructor(
    public dialogRef: MatDialogRef<MessageComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string,
    private translate: TranslateService
  ) {
    this.data = this.translate.instant(this.data);
  }

  public onClickOk = () => {
    this.dialogRef.close();
  };
}

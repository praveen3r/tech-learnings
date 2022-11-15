import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  templateUrl: './confirm-message.component.html',
})
export class ConfirmMessageComponent {
  constructor(
    public dialogRef: MatDialogRef<ConfirmMessageComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string
  ) {}

  public onClickCancel = () => {
    this.dialogRef.close(false);
  };

  public onClickOk = () => {
    this.dialogRef.close(true);
  };
}

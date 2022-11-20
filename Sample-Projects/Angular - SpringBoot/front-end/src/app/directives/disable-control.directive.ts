import { Directive, Input } from '@angular/core';
import { NgControl } from '@angular/forms';

@Directive({
  selector: '([formControlName], [formControl])[disableControl]',
})
export class DisableControlDirective {
  @Input() set disableControl(condition: boolean) {
    const action = condition ? 'disable' : 'enable';

    console.log(this.ngControl.control);

    this.ngControl.disabled;
  }

  constructor(private ngControl: NgControl) {}
}

import { Directive, ElementRef, Input } from '@angular/core';
import { GeneralUtils } from '../utils/GeneralUtils';

@Directive({
  selector: '[allowChar]',
  host: {
    '(ngModelChange)': 'onInputChange()',
  },
})
export class InputCharDirective {
  @Input() allowChar: string;
  constructor(private el: ElementRef) {}

  onInputChange() {
    let input: string = this.el.nativeElement.value;
    let transformedInput: string;
    if (this.allowChar === 'AN') {
      transformedInput = GeneralUtils.removeSpecialChar(input);
    } else if (this.allowChar === 'N') {
      transformedInput = GeneralUtils.removeChar(input);
    } else if (this.allowChar === 'DN') {
      transformedInput = GeneralUtils.allowDecimal(input);
    } else {
      transformedInput = GeneralUtils.removeSpecialChar(input);
    }
    if (transformedInput) {
      this.el.nativeElement.value = transformedInput;
    } else {
      this.el.nativeElement.value = '';
    }
  }
}

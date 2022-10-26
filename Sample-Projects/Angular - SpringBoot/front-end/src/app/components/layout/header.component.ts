import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { DropDownOptions } from 'src/app/types/FormTypes';

@Component({
  selector: 'Header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  public optionList: DropDownOptions[] = [
    {
      id: 'en',
      value: 'English',
    },
    {
      id: 'de',
      value: 'German',
    },
    {
      id: 'fr',
      value: 'French',
    },
  ];

  constructor(private translate: TranslateService) {}

  ngOnInit(): void {}

  public onChangeLanguage = (event: Event) => {
    const lang = (event.target as HTMLInputElement).value;
    this.translate.use(lang);
  };
}

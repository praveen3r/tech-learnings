import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { AuthenticationService } from '../../services/common/authentication.service';
import { DropDownOptions } from './../../types/FormTypes';

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

  constructor(
    private translate: TranslateService,
    private router: Router,
    private authentication: AuthenticationService
  ) {}

  ngOnInit(): void {}

  public onChangeLanguage = (event: Event) => {
    const lang = (event.target as HTMLInputElement).value;
    this.translate.use(lang);
  };

  onLogout() {
    this.authentication.logout();
    this.router.navigate(['./home']);
  }
}

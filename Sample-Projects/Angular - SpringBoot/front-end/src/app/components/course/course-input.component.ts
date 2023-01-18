import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { Observable, Subject } from 'rxjs';
import { Course } from 'src/app/entity/Course';
import { CourseTypeMaster } from '../../entity/CourseTypeMaster';
import { MessageService } from '../../services/common/message.service';
import { CourseService } from '../../services/course/course.service';
import { Constants } from '../../utils/Constants';
import { GeneralUtils } from '../../utils/GeneralUtils';

@Component({
  templateUrl: 'course-input.component.html',
  styles: [],
})
export class CourseInputComponent implements OnInit {
  public courseInputForm: FormGroup;
  public isError: boolean = false;
  public isInfo: boolean = false;
  public errMsg = '';
  public close: Subject<boolean> = new Subject<boolean>();
  public onClose: Observable<boolean>;
  public isAdd: boolean = false;
  public course: Course;
  public courseTypeList: CourseTypeMaster[];

  constructor(
    private fb: FormBuilder,
    private courseService: CourseService,
    private translate: TranslateService,
    private modalRef: BsModalRef,
    private msgService: MessageService
  ) {
    this.onClose = this.close.asObservable();
  }

  public ngOnInit(): void {
    this.initForm();
    this.fetchCourseTypes();
  }

  private initForm = () => {
    this.courseInputForm = this.fb.group({
      name: new FormControl(this.course.name, Validators.required),
      type: new FormControl(
        this.course.typeId ? this.course.typeId : '',
        Validators.required
      ),
      author: new FormControl(this.course.author, Validators.required),
    });
  };

  private fetchCourseTypes = () => {
    this.courseService.getCourseTypes().subscribe((response) => {
      if (response.course_types) {
        this.courseTypeList = response.course_types;
      }
    });
  };

  public onClickSubmit = () => {
    this.clearError();
    const name = this.courseInputForm.value.name;
    const typeId = this.courseInputForm.value.type;
    const author = this.courseInputForm.value.author;
    if (this.courseInputForm.invalid) {
      this.errMsg = this.translate.instant('plsFillManFields') + ': ';
      this.validateFormData(name, typeId, author);
      this.errMsg = GeneralUtils.removeLastChar(this.errMsg);
      this.isError = true;
    } else {
      const course: Course = {
        id: this.course.id,
        name,
        typeId,
        author,
      };
      this.processData(course);
    }
  };

  private validateFormData = (...arrgs: string[]) => {
    if (GeneralUtils.isEmpty(arrgs[0])) {
      this.errMsg =
        this.errMsg + ' ' + this.translate.instant('course.name') + ',';
    }
    if (GeneralUtils.isEmpty(arrgs[1])) {
      this.errMsg =
        this.errMsg + ' ' + this.translate.instant('course.type') + ',';
    }
    if (GeneralUtils.isEmpty(arrgs[2])) {
      this.errMsg =
        this.errMsg + ' ' + this.translate.instant('course.author') + ',';
    }
  };

  private processData = (course: Course) => {
    if (this.isAdd) {
      this.addCourse(course);
    } else {
      this.processUpdate(course);
    }
  };

  private processUpdate = (course: Course) => {
    if (GeneralUtils.isEqual(course, this.course)) {
      this.isInfo = true;
    } else {
      this.updateCourse(course);
    }
  };

  private updateCourse = (course: Course) => {
    this.courseService
      .updateCourse(course, course.id)
      .subscribe((response: HttpResponse<void>) => {
        if (response.status == Constants.HTTP_PUT_SUCCESS_CODE) {
          this.close.next(true);
          this.modalRef.hide();
          this.msgService.displayUpdateSuccessMsg('menu.course');
        }
      });
  };

  private addCourse = (course: Course) => {
    this.courseService
      .addCourses(course)
      .subscribe((response: HttpResponse<void>) => {
        if (response.status == Constants.HTTP_POST_SUCCESS_CODE) {
          this.close.next(true);
          this.modalRef.hide();
          this.msgService.displayAddSuccessMsg('menu.course');
        }
      });
  };

  public onClickBack = () => {
    this.close.next(false);
    this.modalRef.hide();
  };

  public onClickClear = () => {
    this.courseInputForm.reset();
    this.clearError();
  };

  public onClickReset = () => {
    this.initForm();
    this.clearError();
  };

  private clearError = () => {
    this.errMsg = '';
    this.isError = false;
    this.isInfo = false;
  };
}

import { CourseTypeMaster } from '../model/CourseTypeMaster';
import { Course } from './../model/Course';

export type CourseType = {
  courses: Course[];
};

export type CourseTypeMasterRes = {
  course_types: CourseTypeMaster[];
};

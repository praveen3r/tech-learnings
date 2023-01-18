import { Course } from '../entity/Course';
import { CourseTypeMaster } from '../entity/CourseTypeMaster';

export type CourseType = {
  courses: Course[];
};

export type CourseTypeMasterRes = {
  course_types: CourseTypeMaster[];
};

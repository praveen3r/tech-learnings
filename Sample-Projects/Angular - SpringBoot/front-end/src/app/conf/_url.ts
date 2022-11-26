import { environment } from '../environments/environment';

const server = environment.server;

export const url = {
  TOKEN_SERVICE: `${server}/api/sec/seckey/`,
  COURSE_SERVICE: `${server}/api/v1/courses/`,
  COURSE_MODIFY_SERVICE: `${server}/api/v1/courses/course`,
  COURSE_SEARCH_SERVICE: `${server}/api/v1/courses/course/search`,
  COURSE_TYPES_SERVICE: `${server}/api/v1/course/types`,
};

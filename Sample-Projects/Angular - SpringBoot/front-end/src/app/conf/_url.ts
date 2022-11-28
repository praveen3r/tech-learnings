import { environment } from '../environments/environment';

const server = environment.server;

export const url = {
  TOKEN_SERVICE: `${server}/v1/sec/key/`,
  AUTH_SERVICE: `${server}/demo/authentication`,
  COURSE_SERVICE: `${server}/v1/courses/`,
  COURSE_MODIFY_SERVICE: `${server}/v1/courses/course`,
  COURSE_SEARCH_SERVICE: `${server}/v1/courses/course/search`,
  COURSE_TYPES_SERVICE: `${server}/v1/course/types`,
};

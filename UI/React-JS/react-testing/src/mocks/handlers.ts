import { RestHandler, rest } from "msw";

const fetchPosts: RestHandler = rest.get(
  "https://jsonplaceholder.typicode.com/posts",
  (request, response, context) => {
    return response(
      context.status(200),
      context.json([
        {
          userId: 1,
          id: 1,
          title: "test",
          body: "test",
        },
      ]),
    );
  },
);

export const handlers = [fetchPosts];

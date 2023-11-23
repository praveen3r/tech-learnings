import { render, screen } from "@testing-library/react";
import { server } from "../../mocks/servers";
import ErrorHandling from "./ErrorHandling";
import { rest } from "msw";

test("reders list correctly", async () => {
  server.use(
    rest.get(
      "https://jsonplaceholder.typicode.com/posts",
      (request, response, context) => {
        return response(context.status(500));
      },
    ),
  );

  render(<ErrorHandling />);

  const item = await screen.findByText("unexpected error");
  expect(item).toBeInTheDocument();
});

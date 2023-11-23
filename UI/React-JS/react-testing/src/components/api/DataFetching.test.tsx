import { render, screen } from "@testing-library/react";
import DataFetching from "./DataFetching";

test("reders list correctly", async () => {
  render(<DataFetching />);
  const listItemElement = await screen.findAllByRole("listitem");
  expect(listItemElement).toHaveLength(1);
});

import { render, screen } from "@testing-library/react";
import Counter from "./Counter";
import userEvent from "@testing-library/user-event";

test("test1", () => {
  render(<Counter />);
  const buttonElement = screen.getByRole("button", {
    name: "Increment",
  });
  expect(buttonElement).toBeInTheDocument();
});

test("test2", async () => {
  render(<Counter />);
  await userEvent.click(
    screen.getByRole("button", {
      name: "Increment",
    }),
  );
  const headingElement = screen.getByRole("heading");
  expect(headingElement).toHaveTextContent("1");
});

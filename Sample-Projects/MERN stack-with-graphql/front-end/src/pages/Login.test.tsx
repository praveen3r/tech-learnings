import userEvent from "@testing-library/user-event";
import { fireEvent, render, screen, waitFor } from "../util/TestUtil";
import Login from "./Login";

test("rendering input element", () => {
  render(<Login />);
  const usernameElement = screen.getByRole("textbox", {
    name: /username:/i,
  });
  expect(usernameElement).toBeInTheDocument();

  const keywordElement = screen.getByText(/password:/i);
  expect(keywordElement).toBeInTheDocument();
});

test("rendering button element and testing click function", async () => {
  render(<Login />);
  const submitElement = screen.getByRole("button", {
    name: /submit/i,
  });
  expect(submitElement).toBeInTheDocument();

  const clearElement = screen.getByRole("button", {
    name: /clear/i,
  });
  expect(clearElement).toBeInTheDocument();

  await userEvent.click(
    screen.getByRole("button", {
      name: /clear/i,
    })
  );

  const usernameElement = screen.getByRole("textbox", {
    name: /username:/i,
  });
  expect(usernameElement).toHaveTextContent("");
});

test("form submit error message", async () => {
  render(<Login />);

  const submitButton = screen.getByText("Submit");
  fireEvent.click(submitButton);
  await waitFor(() => {
    expect(screen.getByText("Username is required")).toBeInTheDocument();
    expect(screen.getByText("Password is required")).toBeInTheDocument();
  });
});

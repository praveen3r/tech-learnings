import { render, screen } from "@testing-library/react";
import CounterTwo from "./CounterTwo";
import userEvent from "@testing-library/user-event";

test("test1", () => {
  render(<CounterTwo counter={0} />);
  const buttonElement = screen.getByRole("button", {
    name: "Increment",
  });
  expect(buttonElement).toBeInTheDocument();
});

test("test2", async () => {
  const incrementFn = jest.fn();
  const decrementFn = jest.fn();
  render(
    <CounterTwo handleIncrement={incrementFn} handleDecrement={decrementFn} />,
  );
  await userEvent.click(
    screen.getByRole("button", {
      name: "Increment",
    }),
  );
  await userEvent.click(
    screen.getByRole("button", {
      name: "Decrement",
    }),
  );
  expect(incrementFn).toHaveBeenCalledTimes(1);
  expect(decrementFn).toHaveBeenCalledTimes(1);
});

import { render, screen } from "@testing-library/react";
import Greet from "./greet";

it("test1", () => {
  render(<Greet />);
  const linkElement = screen.getByText(/greet/i);
  expect(linkElement).toBeInTheDocument();
});

it("props", () => {
  render(<Greet name="Prav" />);
  const linkElement = screen.getByText("greet Prav");
  expect(linkElement).toBeInTheDocument();
});

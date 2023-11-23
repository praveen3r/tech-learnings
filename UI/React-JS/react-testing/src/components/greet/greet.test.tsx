import { render, screen } from "@testing-library/react";
import Greet from "./greet";

describe("Greet", () => {
  test("test1", () => {
    render(<Greet />);
    const linkElement = screen.getByText(/greet/i);
    expect(linkElement).toBeInTheDocument();
  });

  describe("Nested", () => {
    test("props", () => {
      render(<Greet name="Prav" />);
      const linkElement = screen.getByText("greet Prav");
      expect(linkElement).toBeInTheDocument();
    });
  });
});

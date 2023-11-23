import { render, screen } from "@testing-library/react";
import Application from "./Application";

describe("Application", () => {
  test("roles", () => {
    render(<Application />);
    const pageHeadingElement = screen.getByRole("heading", {
      level: 1,
    });
    expect(pageHeadingElement).toBeInTheDocument();

    const sectionHeadingElement = screen.getByRole("heading", {
      level: 2,
    });
    expect(sectionHeadingElement).toBeInTheDocument();

    const nameElement = screen.getByRole("textbox", {
      name: "Name",
    });
    expect(nameElement).toBeInTheDocument();

    //getByLabelText
    const nameElement2 = screen.getByLabelText("Name");
    expect(nameElement2).toBeInTheDocument();

    //getByPlaceholderText
    const nameElement3 = screen.getByPlaceholderText("enter name");
    expect(nameElement3).toBeInTheDocument();

    //getByDisplayValue
    const nameElement4 = screen.getByDisplayValue("Demo");
    expect(nameElement4).toBeInTheDocument();

    const bioElement = screen.getByRole("textbox", {
      name: "Bio",
    });
    expect(bioElement).toBeInTheDocument();

    //getByText
    const paragraphElement = screen.getByText("All fields are mandatory");
    expect(paragraphElement).toBeInTheDocument();

    //getByTitle
    const spanElement = screen.getByTitle("close");
    expect(spanElement).toBeInTheDocument();

    //getByTitle
    const testElement = screen.getByTestId("test");
    expect(testElement).toBeInTheDocument();

    const dropdownElement = screen.getByRole("combobox");
    expect(dropdownElement).toBeInTheDocument();

    const checkboxElement = screen.getByRole("checkbox");
    expect(checkboxElement).toBeInTheDocument();

    const buttonElement = screen.getByRole("button");
    expect(buttonElement).toBeInTheDocument();
  });
});

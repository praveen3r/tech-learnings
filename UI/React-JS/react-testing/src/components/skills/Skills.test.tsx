import { render, screen } from "@testing-library/react";
import Skills from "./Skills";

const skillsData = [
  {
    id: 1,
    name: "HTMl",
  },
  {
    id: 2,
    name: "Java",
  },
  {
    id: 3,
    name: "Spring",
  },
];

test("reders correctly", () => {
  render(<Skills data={skillsData} />);
  const listElement = screen.getByRole("list");
  expect(listElement).toBeInTheDocument();
});

test("reders list correctly", () => {
  render(<Skills data={skillsData} />);
  const listItemElement = screen.getAllByRole("listitem");
  expect(listItemElement).toHaveLength(skillsData.length);
});

test("Dashboard is not rendered", () => {
  render(<Skills isLoggedIn={false} />);
  const listItemElement = screen.queryByRole("button", { name: "Dashboard" });
  expect(listItemElement).not.toBeInTheDocument();
});

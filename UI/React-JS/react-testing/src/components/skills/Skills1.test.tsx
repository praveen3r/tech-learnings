import { logRoles, render, screen } from "@testing-library/react";
import Skills1 from "./Skills1";

test("renders correctly", async () => {
  const view = render(<Skills1 />);
  logRoles(view.container);

  //screen.debug();
  const buttonElement = await screen.findByRole(
    "button",
    {
      name: "Dashboard",
    },
    {
      timeout: 2000,
    },
  );
  //screen.debug();
  expect(buttonElement).toBeInTheDocument();
});

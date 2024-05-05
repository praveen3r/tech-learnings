import { render, screen } from "../../util/TestUtil";
import UserDetails from "./UserDetails";

test("rendering input element", () => {
  const showModal = true;
  const hideModal = () => false;
  const confirmModal = jest.fn();
  const data = {
    sNo: 1,
    name: "",
    age: 1,
    gender: "",
    genderOptions: [
      {
        key: "M",
        value: "Male",
      },
      {
        key: "F",
        value: "Female",
      },
    ],
  };
  render(
    <UserDetails
      showModal={showModal}
      hideModal={hideModal}
      confirmModal={confirmModal}
      data={data}
    />
  );
  const nameElement = screen.getByRole("textbox", {
    name: /name:/i,
  });
  expect(nameElement).toBeInTheDocument();
});

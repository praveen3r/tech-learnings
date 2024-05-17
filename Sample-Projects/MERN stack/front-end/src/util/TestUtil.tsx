import { RenderOptions, render } from "@testing-library/react";
import { ReactElement } from "react";
import CustomProvider from "../providers/CustomProvider";

const AllTheProviders = ({ children }: { children: React.ReactNode }) => {
  return <CustomProvider>{children}</CustomProvider>;
};

const customRender = (
  ui: ReactElement,
  options?: Omit<RenderOptions, "wrapper">
) => render(ui, { wrapper: AllTheProviders, ...options });

export * from "@testing-library/react";
export { customRender as render };

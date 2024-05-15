import { BrowserRouter } from "react-router-dom";
import { LangProvider } from "../components/context/LangContent";
import Provider from "../components/i18n/Provider";
import { ChildrenType } from "../types/ComponentType";

const CustomProvider = ({ children }: ChildrenType) => {
  return (
    <LangProvider>
      <Provider>
          <BrowserRouter>{children}</BrowserRouter>
      </Provider>
    </LangProvider>
  );
};

export default CustomProvider;

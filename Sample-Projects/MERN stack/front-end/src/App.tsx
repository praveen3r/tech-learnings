import React, { useEffect, useState } from "react";
import { useIntl } from "react-intl";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { AuthProvider } from "./components/context/Auth";
import MessageModal from "./components/modal/MessageModal";
import Dashboard from "./pages/Dashboard";
import Login from "./pages/Login";
import GuardedRoute from "./pages/route/GuardedRoute";
import { routes } from "./pages/route/Routes";

function App() {
  const [displayModal, setDisplayModal] = useState(false);
  const [message, setMessage] = useState<string>("");

  const intl  = useIntl();
  

  useEffect(() => {
    const handleContextmenu = (event: MouseEvent) => {
      setDisplayModal(true);
      setMessage(intl.formatMessage({id: 'operationNotAllow'}));
      event.preventDefault();
    };
    document.addEventListener("contextmenu", handleContextmenu);
    return () => {
      hideModal();
      document.removeEventListener("contextmenu", handleContextmenu);
    };
  }, []);

  const hideModal = () => {
    setDisplayModal(false);
  };

  const routeComponents = routes.map(({ path, component }, key) => (
    <Route
      path={path}
      element={<GuardedRoute>{component}</GuardedRoute>}
      key={key}
    />
  ));

  return (
    <>
      {
        <AuthProvider>
          <Router>
            <Dashboard />
            <Routes>
              <Route path="" element={<Login />} />
              <Route path="login" element={<Login />} />
              {routeComponents}
            </Routes>
          </Router>
        </AuthProvider>
      }
      <MessageModal
        showModal={displayModal}
        hideModal={hideModal}
        message={message}
      />
    </>
  );
}

export default App;

import React, { useEffect, useState } from "react";
import { useIntl } from "react-intl";
import { BrowserRouter as Router, Routes, Route, useNavigate } from "react-router-dom";
import { AuthProvider, useAuth } from "./components/context/Auth";
import MessageModal from "./components/modal/MessageModal";
import Dashboard from "./pages/Dashboard";
import Login from "./pages/Login";
import GuardedRoute from "./pages/route/GuardedRoute";
import { routes } from "./pages/route/Routes";

function App() {
  const [displayModal, setDisplayModal] = useState(false);
  const [message, setMessage] = useState<string>("");

  const intl  = useIntl();

  const auth = useAuth();
  
  
  const displayModalPopUp = (event: MouseEvent | KeyboardEvent) => {
    setDisplayModal(true);
    setMessage(intl.formatMessage({id: 'operationNotAllow'}));
    event.preventDefault();
    event.stopPropagation();
    
  }
  
  const processContextmenu = (event: MouseEvent) => {
    displayModalPopUp(event);
  };

  const processKeyDown = (event: KeyboardEvent) => {
    var input_key = event.code;
    if (
      input_key === 'F5' ||
      input_key === 'F10' ||
      input_key === 'F11' ||
      input_key === 'F12'
    ) {
      //F5, F10, F11, F12
      displayModalPopUp(event);
    } else if (event.ctrlKey) {
      // Ctrl + R, Ctrl + Shift + R
      if (input_key === 'KeyR') {
        displayModalPopUp(event);
      }
    }
  }

  const processOnBeforeUnload = (event: Event) => {
   if(auth?.isAuthenticated){
    auth!.logout();
    
   }
  }

  useEffect(() => {
    
    document.addEventListener("contextmenu", processContextmenu);
    document.addEventListener('keydown', processKeyDown);
    window.addEventListener("beforeunload", processOnBeforeUnload);

    return () => {
      hideModal();
      document.removeEventListener("contextmenu", processContextmenu);
      document.removeEventListener("keydown", processKeyDown);
      window.removeEventListener("beforeunload", processOnBeforeUnload);
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
            <Dashboard />
            <Routes>
              <Route path="" element={<Login />} />
              <Route path="login" element={<Login />} />
              {routeComponents}
            </Routes>
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

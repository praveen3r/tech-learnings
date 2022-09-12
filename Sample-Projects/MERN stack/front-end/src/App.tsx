import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { AuthProvider } from "./components/context/Auth";
import Login from "./pages/Login";
import GuardedRoute from "./pages/route/GuardedRoute";
import { routes } from "./pages/route/Routes";

function App() {
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
          <Routes>
            <Route path="" element={<Login />} />
            <Route path="login" element={<Login />} />
            {routeComponents}
          </Routes>
        </Router>
        </AuthProvider>
      }
    </>
  );
}

export default App;

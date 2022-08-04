import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { routes } from "./pages/route/Routes";

function App() {
  const routeComponents = routes.map(({ path, component }, key) => (
    <Route path={path} element={component} key={key} />
  ));

  return (
    <>
      {
       <Router>
        <Routes>{routeComponents}</Routes>
      </Router> }
    </>
  );
}

export default App;

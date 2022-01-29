import React from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import './App.css';
import MenuBar from './components/layout/MenuBar';
import { AuthProvider } from './util/Auth';
import { routes } from './util/Routes'


function App() {
  const routeComponents = routes.map(({ path, component }, key) => <Route path={path} element={component} key={key} />);
  return (
    <>
      <AuthProvider>
        <MenuBar />
        <Routes>
          {routeComponents}
        </Routes>
      </AuthProvider>
    </>
  );
}

export default App;

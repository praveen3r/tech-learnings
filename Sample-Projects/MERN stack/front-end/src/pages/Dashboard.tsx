import React from "react";
import { useAuth } from "../components/context/Auth";
import Header from "../components/Header/Header";
import NavMenu from "../components/nav/NavMenu";

function Dashboard() {
  const auth = useAuth();
  if (auth?.isAuthenticated) {
    return (
      <>
        <Header />
        <NavMenu />
      </>
    );
  }
  return <></>;
  
}

export default Dashboard;

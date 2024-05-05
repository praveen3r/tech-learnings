import React from "react";
import { useAuth } from "../components/context/Auth";
import Header from "../components/Header/Header";
import NavMenu from "../components/nav/NavMenu";
import IdleTimeOutHandler from "../components/idle-time-out/IdleTimeoutHandler";

function Dashboard() {
  const auth = useAuth();
  
  if (auth?.isAuthenticated) {
    return (
      <>
      <IdleTimeOutHandler />
        <Header />
        <NavMenu />
      </>
    );
  }
  return <></>;
  
}

export default Dashboard;

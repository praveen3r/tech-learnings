import React from "react";
import { useAuth } from "../components/context/Auth";
import Header from "../components/Header/Header";
import NavMenu from "../components/nav/NavMenu";
import {useState} from "react";
import IdleTimeOutHandler from "../components/idle-time-out/IdleTimeoutHandler";

function Dashboard() {
  const auth = useAuth();
  const[isActive,setIsActive]=useState<Boolean>(true);
  
  if (auth?.isAuthenticated) {
    return (
      <>
      <IdleTimeOutHandler onActive={()=>{setIsActive(true)}} onIdle={()=>{setIsActive(false)}}/>
        <Header />
        <NavMenu />
      </>
    );
  }
  return <></>;
  
}

export default Dashboard;

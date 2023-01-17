import React, { useEffect, useState, useRef } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/Auth";
import { IdleTimeOutModal } from "../modal/IdleTimeOutModal";

const timeOut = +(process.env.REACT_APP_IDLE_WARNING!) * 1000;

const IdleTimeOutHandler = (props: any) => {
  const intervalRef = useRef<NodeJS.Timer>();

  const events = ["click", "scroll", "load", "keydown"];

  const [showModal, setShowModal] = useState<boolean>(false);
  const auth = useAuth();
  const navigate = useNavigate();
  

  useEffect(() => {
    startWatching();

    return () => {
      stopWatching();
    };
  }, []);

  const startTimer = () => {
    intervalRef.current = setTimeout(() => {
      setShowModal(true);
    }, timeOut);
  };

  const resetTimer = () => {
    clearTimeout(intervalRef.current);
    intervalRef.current = setTimeout(() => {
      setShowModal(true);
    }, timeOut);
  };

  const startWatching = () => {
    events.forEach((eventName) => {
      window.addEventListener(eventName, eventHandler);
    });
    startTimer();
  };

  const stopWatching = () => {
    events.forEach((eventName) => {
      window.removeEventListener(eventName, eventHandler);
    });
    clearTimeout(intervalRef.current);
  };

  const eventHandler = (eventType: any) => {
    resetTimer();
  };

  const handleContinueSession = () => {
    resetTimer();
    setShowModal(false);
  };

  const handleLogout = () => {
    auth!.logout();
    navigate("/login");
  };

  return (
    <>
      <IdleTimeOutModal
        showModal={showModal}
        handleContinue={handleContinueSession}
        handleLogout={handleLogout}
      />
    </>
  );
};

export default IdleTimeOutHandler;

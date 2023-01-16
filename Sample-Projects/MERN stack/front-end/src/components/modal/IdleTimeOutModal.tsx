import React, { useState, useEffect, useRef } from "react";
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";
import { IdleTimeOutType } from "../../types/ComponentType";
import DisplayMessage from "../i18n/DisplayMessage";

export const IdleTimeOutModal = (props: IdleTimeOutType) => {
  const { showModal, handleContinue, handleLogout } = props;

  const [count, setCount] = useState(20);
  const intervalRef = useRef<NodeJS.Timer>();

  const timerFunc = () => {
      setCount((prevCount) => prevCount - 1);
  };

  useEffect(() => {
    console.log(`coming here`);

    if(showModal){
      intervalRef.current = setInterval(timerFunc, 1000);
    }else{
      clearInterval(intervalRef.current);
    }

    return () => {
      clearInterval(intervalRef.current);
    };
  }, [showModal]);

  useEffect(() => {
    console.log(`coming to timer ${count}`);
    
    if (count === 1) {
      console.log(`coming to logout`);
      handleLogout();
    }
  }, [count]);

  const onClickContinue = () => {
    //setCount(20);
    clearInterval(intervalRef.current);
    handleContinue();
  };

  const onClickLogout = () => {
    clearInterval(intervalRef.current);
    handleLogout();
  };

  return (
    <>
      {showModal && (
        <Modal show={showModal} onHide={handleContinue}>
          <Modal.Header closeButton>
            <Modal.Title>
              <DisplayMessage id="continue" />
            </Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <small>You'll be logged out in {count} second(s).</small>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="primary" onClick={onClickContinue}>
              <DisplayMessage id="continue" />
            </Button>
            <Button variant="danger" onClick={onClickLogout}>
              <DisplayMessage id="logout" />
            </Button>
          </Modal.Footer>
        </Modal>
      )}
    </>
  );
};

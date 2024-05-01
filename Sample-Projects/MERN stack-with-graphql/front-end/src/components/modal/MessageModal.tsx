import React from "react";
import { Modal, Button } from "react-bootstrap";
import { MessageModalType } from "../../types/ComponentType";
import DisplayMessage from "../i18n/DisplayMessage";

const MessageModal = ({
  showModal,
  hideModal,
  message,
}: MessageModalType) => {
  return (
    <Modal
      show={showModal}
      onHide={hideModal}
      backdrop="static"
      keyboard={false}
    >
      <Modal.Header closeButton>
      </Modal.Header>
      <Modal.Body>
        <div className="alert alert-info">{message}</div>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="info" onClick={hideModal}>
          <DisplayMessage id="ok" />
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default MessageModal;

import React from "react";
import { Modal, Button } from "react-bootstrap";
import { DeleteConfirmationType } from "../../types/ComponentType";
import DisplayMessage from "../i18n/DisplayMessage";

const DeleteConfirmation = ({
  showModal,
  hideModal,
  confirmModal,
  message,
  id,
}: DeleteConfirmationType) => {
  return (
    <Modal
      show={showModal}
      onHide={hideModal}
      backdrop="static"
      keyboard={false}
    >
      <Modal.Header closeButton>
        <Modal.Title>
          <DisplayMessage id="delete" /> <DisplayMessage id="confirmation" />
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <div className="alert alert-danger">{message}</div>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="danger" onClick={() => confirmModal(id)}>
          <DisplayMessage id="delete" />
        </Button>
        <Button variant="default" onClick={hideModal}>
          <DisplayMessage id="cancel" />
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default DeleteConfirmation;

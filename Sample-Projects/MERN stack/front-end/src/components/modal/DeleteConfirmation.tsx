import React from 'react'
import { Modal, Button } from "react-bootstrap";
import { DeleteConfirmationType } from '../../types/ComponentType';
 
const DeleteConfirmation = ({ showModal, hideModal, confirmModal, message, id }: DeleteConfirmationType) => {
    return (
        <Modal show={showModal} onHide={hideModal}
        backdrop="static"
        keyboard={false}>
        <Modal.Header closeButton>
          <Modal.Title>Delete Confirmation</Modal.Title>
        </Modal.Header>
        <Modal.Body><div className="alert alert-danger">{message}</div></Modal.Body>
        <Modal.Footer>
        <Button variant="danger" onClick={() => confirmModal(id) }>
            Delete
          </Button>
          <Button variant="default" onClick={hideModal}>
            Cancel
          </Button>
        </Modal.Footer>
      </Modal>
    )
}
 
export default DeleteConfirmation;
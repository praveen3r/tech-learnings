import React, { useState } from 'react';
import { toast } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Modal from 'react-modal'

toast.configure();
Modal.setAppElement("#root");
function Others() {

  const [modalIsOpen, setModalIsOpen] = useState(false)

  const notify = () => {
    toast('Basic notification');
    toast.success('Success notification', { position: toast.POSITION.TOP_LEFT, autoClose: 8000});
    toast.info('Info notification', { position: toast.POSITION.TOP_CENTER, autoClose: false});
    toast.warn('Warning notification', { position: toast.POSITION.BOTTOM_LEFT});
    toast.error('Error notification', { position: toast.POSITION.BOTTOM_RIGHT});
  }
  return (
    <>
    <div><a href="#" onClick={notify}>Test toaster</a></div>

    <div><a href="#" onClick={() => setModalIsOpen(true)}>Test Modal</a></div>
    <Modal isOpen={modalIsOpen}>
      test modal
      <div>
        <button onClick={() => setModalIsOpen(false)}>Close</button>
      </div>
    </Modal>
    </>
  );
}

export default Others;

import React, { useEffect, useState } from 'react';
import { toast } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Modal from 'react-modal'
import Button from './Button';

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

  const [counter1, setCounter1] = useState(0);
  const [counter2, setCounter2] = useState(0);
  const [counter3, setCounter3] = useState(0);
  const [counter4, setCounter4] = useState(0);

  const [data, setData] = useState([]);

     let buttonArr = [
      {count: counter1, setCount: setCounter1},
       {count: counter2, setCount: setCounter2}, 
       {count: counter3, setCount: setCounter3},
       {count: counter4, setCount: setCounter4}];

    useEffect(() => {
       buttonArr.sort((obj1, obj2) => obj1.count > obj2.count?  -1: 1);
      setData(buttonArr);
   }, [counter1, counter2, counter3, counter4]);

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

    <div>Sort button based on counter</div>
    <Button buttonArr={data}></Button>
    </>
  );
}

export default Others;

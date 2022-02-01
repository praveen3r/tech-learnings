import React, { useEffect, useState } from 'react';

function Forms() {

  const [testInput, setTestInput] = useState('');
  // disable right click
  useEffect(() => {
    document.addEventListener('contextmenu', (e) => {
      e.preventDefault();
    });
  }, []);

  const onChangeInput = (e) => {
    const re = /[^a-z0-9\s]*/gi;
    if (e.target.value !== "") {
      const transformedInput = e.target.value.replace(/[^a-z0-9\s]*/gi, "");
      setTestInput(transformedInput );
    }
  }

  return (
    <>
      <div><input type="text" onPaste={e => { e.preventDefault(); return false }} placeholder='basic text' /></div>
      <div><input type="text" value={testInput} onChange={onChangeInput} placeholder='Test reg text' /></div>
    </>
  );

}



export default Forms;

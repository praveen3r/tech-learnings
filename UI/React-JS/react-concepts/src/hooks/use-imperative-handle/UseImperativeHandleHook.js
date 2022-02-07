import React, { useRef } from 'react';
import Counter from './Counter';

function UseImperativeHandleHook() {
  const ref = useRef();
  return (
  <>
  <Counter ref={ref}/>

  <button onClick={() => ref.current.increment()}>Custom Click</button>
  </>
  );
}

export default UseImperativeHandleHook;

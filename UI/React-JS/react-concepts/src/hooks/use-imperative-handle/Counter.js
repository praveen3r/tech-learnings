import React, {forwardRef, useImperativeHandle, useState} from 'react';

const Counter = forwardRef((props, ref) => {
  useImperativeHandle(ref, () => {
    return {
      increment: increment
    }
  })
  const [count, setCount] = useState(0);
  const increment = () => {
      setCount(prevCount => prevCount + 1);
  }
  return (
  <>
  {count}
   <div><button onClick={increment}>Click</button></div>
  </>
  );
})

export default Counter;

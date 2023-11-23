import React, { useState } from "react";

const Counter = () => {
  const [counter, setCounter] = useState<number>(0);

  const increment = () => {
    setCounter((prevCount) => prevCount + 1);
  };

  return (
    <>
      <h1>{counter}</h1>
      <button onClick={increment}>Increment</button>
    </>
  );
};

export default Counter;

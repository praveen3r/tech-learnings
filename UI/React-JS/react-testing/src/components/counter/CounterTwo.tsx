import React from "react";

const CounterTwo = (props: any) => {
  return (
    <>
      <h1>{props.counter}</h1>
      <button onClick={props.handleIncrement}>Increment</button>
      <button onClick={props.handleDecrement}>Decrement</button>
    </>
  );
};

export default CounterTwo;

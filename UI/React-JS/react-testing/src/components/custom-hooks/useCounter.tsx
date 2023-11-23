import { useState } from "react";

function useCounter({ initialValue, incrementValue }: any) {
  const [count, setCount] = useState<number>(initialValue);

  const increment = () => {
    setCount((prevCount) => prevCount + incrementValue);
  };

  const decrement = () => {
    setCount((prevCount) => prevCount - incrementValue);
  };

  const reset = () => {
    setCount(initialValue);
  };

  return { count, increment, decrement, reset };
}

export default useCounter;

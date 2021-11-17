import React from 'react'
import useCounter from './useCounter'

function DemoCounter() {

    const [count, increment, decrement, reset] = useCounter(10 , 2);

    return (
        <div>
            Count is {count}
            <br/><button onClick={increment}>increment</button>
            <button onClick={decrement}>decrement</button>
            <button onClick={reset}>reset</button>
        </div>
    )
}

export default DemoCounter

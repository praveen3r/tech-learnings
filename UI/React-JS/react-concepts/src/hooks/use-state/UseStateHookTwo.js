import React,{useState} from 'react'

function UseStateHookTwo() {
    
    const initialCount = 0;
    const [count, incrementCount] = useState(initialCount);

    const incrementByFive = () => {
        for(let i=0; i< 5;i++){
            incrementCount(prevCount => prevCount + 1);
        }
    }

    return (
        <div>
            Count {count} <br/>
            <button onClick={() => incrementCount(initialCount)}> Reset </button>
            <button onClick={() => incrementCount(prevCount => prevCount + 1)}> Increment </button>
            <button onClick={() => incrementCount(prevCount => prevCount - 1)}> Decrement </button>
            <button onClick={incrementByFive}> Increment by 5 </button>
        </div>
    )
}

export default UseStateHookTwo

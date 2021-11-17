import React,{useState, useEffect, useRef} from 'react'

function Timer() {

    const [count, setCount] = useState(0);
    const intervalRef = useRef();

    useEffect(() => {
        intervalRef.current = setInterval(() => {
            setCount(prevCount => prevCount + 1)
        }, 1000)
        return () => {
            clearInterval(intervalRef.current)
        }
    }, [])
    return (
        <div>
            count is {count} <br/>
            <button onClick={() => clearInterval(intervalRef.current)}>Stop counter</button>
        </div>
    )
}

export default Timer

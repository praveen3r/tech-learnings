import React, {useState, useEffect} from 'react'

function Counter() {

    const[count, setCount] = useState(0)

    const timerFunc = () => {
        setCount(prevCount => prevCount + 1);
    }

    useEffect(()=>{
       const interval = setInterval(timerFunc, 1000);

       return () => {
        clearInterval(interval);
       }
    })

    
    return (
        <div>
            {count}
        </div>
    )
}

export default Counter

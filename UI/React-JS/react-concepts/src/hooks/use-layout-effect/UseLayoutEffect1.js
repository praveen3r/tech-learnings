import React, {useState, useLayoutEffect} from 'react'

function UseEffect1() {

    const [count, incrementCount] = useState(0);

    useLayoutEffect(()=>{
        document.title = `You have clicked ${count} times`;
    })

    return (
        <div>
            <button onClick={() => incrementCount(count + 1)}> Count {count}</button>
        </div>
    )
}

export default useLayoutEffect1

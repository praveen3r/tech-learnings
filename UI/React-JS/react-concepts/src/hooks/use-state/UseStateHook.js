import React, {useState} from 'react'

function UseStateHook() {

    const [count, incrementCount] = useState(0);

    
    return (
        <div>
            <button onClick={() => incrementCount(count + 1)}> Count {count}</button>
        </div>
    )
}

export default UseStateHook

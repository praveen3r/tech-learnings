import React, {useState, useEffect} from 'react'

function UseEffect2() {

    const [count, incrementCount] = useState(0);
    const [name, setName] = useState('');

    useEffect(()=>{
        console.log("coming here");
        document.title = `You have clicked ${count} times`;
    },[count])

    return (
        <div>
            <input type="text" value={name} onChange={(e) => setName(e.target.value)}/>
            <button onClick={() => incrementCount(count + 1)}> Count {count}</button>
        </div>
    )
}

export default UseEffect2

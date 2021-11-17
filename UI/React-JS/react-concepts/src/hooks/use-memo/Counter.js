import React, {useState, useMemo} from 'react'

function Counter() {
    const [counterOne, setCounterOne] = useState(0);
    const [counterTwo, setCounterTwo] = useState(0);

    const incrementOne = () => {
        setCounterOne(counterOne + 1)
    }

    const incrementTwo = () => {
        setCounterTwo(counterTwo + 1)
    }

    const isEven = useMemo(() => {
        let i=0;
        while ( i < 200000000) i++
        return counterOne % 2 === 0
    }, [counterOne])

    return (
        <div>
            <button onClick={incrementOne}>Increment one - {counterOne}</button>
            <span>{isEven ? ' Even' : ' Odd'}</span>
            <br/>
            <button onClick={incrementTwo}>Increment two - {counterTwo}</button>
        </div>
    )
}

export default Counter

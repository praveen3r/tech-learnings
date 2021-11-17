import React,{useState, useCallback} from 'react'
import Counter from './Counter'
import Button from './Button'

function CallBackEx() {

    const [age, setAge] = useState(30);
    const [salary, setSalary] = useState(50000);

    const incrementAge = useCallback(() => {
        console.log('incrementing age')
        setAge(age + 1);
    },[age])

    const incrementSalary = useCallback(() => {
        console.log('incrementing salary')
        setSalary(salary + 1);
    },[salary])

    return (
        <div>
            <Counter text="age" count={age}></Counter>
            <Button handleClick={incrementAge}>Increment age</Button>
            <Counter text="salary" count={salary}></Counter>
            <Button handleClick={incrementSalary}>Increment salary</Button>
        </div>
    )
}

export default CallBackEx

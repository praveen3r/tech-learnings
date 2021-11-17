import React from 'react'
import useInput from './useInput'

function DemoName() {

    const [firstName, bindFirstName, resetFirstName] = useInput('');
    const [lastName, bindLastName, resetLastName] = useInput('');

    const onSubmitHandler = (e) => {
        e.preventDefault();
        alert(`Hello ${firstName} ${lastName}`)
        resetFirstName();
        resetLastName();
    }

    return (
        <div>
            <form onSubmit={onSubmitHandler}>
                <input type="text" {...bindFirstName}></input><br/>
                <input type="text" {...bindLastName}></input><br/>
                <button type = "submit">Submit</button>
            </form>
        </div>
    )
}

export default DemoName

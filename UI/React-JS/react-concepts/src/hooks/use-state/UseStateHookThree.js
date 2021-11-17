import React, {useState} from 'react'

function UseStateHookThree() {

    const[name, setName] = useState({firstName:'', lastName:''})

    return (
        <div>
            <input type="text" value={name.firstName}
                onChange={(e) => setName({...name, firstName: e.target.value})}></input>
            <input type="text" value={name.lastName}
                onChange={(e) => setName({...name, lastName: e.target.value})}></input><br/>
            First name is {name.firstName} <br/>
            Last name is {name.lastName} <br/>
        </div>
    )
}

export default UseStateHookThree

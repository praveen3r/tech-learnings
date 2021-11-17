import React,{useContext} from 'react'
import UserContext from './../../context/UserContext'

function ComponentB() {

    const userName = useContext(UserContext);
    return (
        <div>
            username is {userName}
        </div>
    )
}

export default ComponentB

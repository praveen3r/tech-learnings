import React, { Component } from 'react'
import {UserConsumer} from './UserContext'

export class ComponentC extends Component {
    render() {
        return (
            <UserConsumer>
                {
                    (userName) => {
                       return <div>user name is {userName}</div>
                    }
                }
            </UserConsumer>
        )
    }
}

export default ComponentC

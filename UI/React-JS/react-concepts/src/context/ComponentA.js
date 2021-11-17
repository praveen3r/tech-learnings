import React, { Component } from 'react'
//import ComponentB from './ComponentB'
import ComponentB from './../hooks/use-context/ComponentB'

export class ComponentA extends Component {
    render() {
        return (
            <div>
                <ComponentB/>
            </div>
        )
    }
}

export default ComponentA

import React, { Component } from 'react'
import Input from './Input'

export class ParentInput extends Component {
    constructor(props) {
        super(props)
    
        this.componentRef = React.createRef();
    }
    
    clickHandler = () =>{
        this.componentRef.current.focusInput();
    }

    render() {
        return (
            <div>
                <Input ref={this.componentRef}></Input>
                <button onClick = {this.clickHandler}>Click</button>
            </div>
        )
    }
}

export default ParentInput

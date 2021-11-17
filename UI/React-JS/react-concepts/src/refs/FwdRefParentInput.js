import React, { Component } from 'react'
import FwdRefInput from './FwdRefInput'

export class FwdRefParentInput extends Component {
    constructor(props) {
        super(props)
    
        this.componentRef = React.createRef();
    }

    clickHandler = () =>{
        this.componentRef.current.focus();
    }
    
    render() {
        return (
            <div>
               <FwdRefInput ref={this.componentRef}></FwdRefInput> 
               <button onClick = {this.clickHandler}>Click</button>
            </div>
        )
    }
}

export default FwdRefParentInput

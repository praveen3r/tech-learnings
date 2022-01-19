import React, { Component } from 'react'
import CounterWithTimer from '../func-comp/CounterWithTimer'

export class ToggleFunc extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             isToggle:true
        }
    }
    
    render() {
        return (
            <div>
                <button onClick={() => this.setState({isToggle: !this.state.isToggle})}>Toggled {this.state.isToggle} value</button>
           {
               this.state.isToggle && <CounterWithTimer/>
           }
            </div>
        )
    }
}

export default ToggleFunc

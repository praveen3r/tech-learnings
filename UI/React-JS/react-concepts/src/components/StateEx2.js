import React, { Component } from 'react'

export class StateEx2 extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             count : 0
        }
    }

    increment(){
        this.setState({
            count : this.state.count + 1
        },
        () => {
            console.log("count is ", this.state.count)
        })
    }

    increment1(){
        console.log("Coming here");
        this.setState(prevValue => ({
            count : prevValue.count + 1
        }),
        () => {
            console.log("count is ", this.state.count)
        })
    }

    incrementMultiple(){
        this.increment1();
        this.increment1();
        this.increment1();
    }
    

    render() {
        return (
            <div>
                <h1>Count is {this.state.count}</h1>
                {/* <button onClick = {() => this.increment()}>Increment</button> */}
                <button onClick = {() => this.incrementMultiple()}>Increment</button>
            </div>
        )
    }
}

export default StateEx2

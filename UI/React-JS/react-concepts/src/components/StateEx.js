import React, { Component } from 'react'

class StateEx extends Component {

    constructor() {
        super()
        this.state = {
            message : 'Hello'
        }
    }

    changeMsg(){
        this.setState({
            message : 'Thank you'
        })
    }

    render() {
        return (
            <div>
                <h1>
                    {this.state.message} state component
                </h1>
                <button onClick={() => this.changeMsg()}>Change</button>
            </div>
        )
    }
}

export default StateEx;
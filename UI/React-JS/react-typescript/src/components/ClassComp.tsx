import React, { Component } from 'react'

type stateType = {
    message: string
}

type propsType = {
    message: string
}

export class ClassComp extends Component<stateType, propsType> {
    state = {
            message : 'Hello'
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
                <p>{this.props.message}</p>
                <button onClick={() => this.changeMsg()}>Change</button>
            </div>
        )
    }
}

export default ClassComp
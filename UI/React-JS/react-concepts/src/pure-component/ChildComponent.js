import React, { Component } from 'react'

export class ChildComponent extends Component {
    render() {
        console.log("Child Component");
        return (
            <div>
                Child Component {this.props.name}
            </div>
        )
    }
}

export default ChildComponent

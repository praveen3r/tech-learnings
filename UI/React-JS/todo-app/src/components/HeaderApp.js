import React, { Component } from 'react'

export class HeaderApp extends Component {
    render() {
        return (
            <div>
                <h1>{this.props.title}</h1>
            </div>
        )
    }
}


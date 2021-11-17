import React, { Component } from 'react'
import ReactDOM from 'react-dom'

export class DemoPortal extends Component {
    render() {
        return ReactDOM.createPortal(
            <div>
                Test portal
            </div>,document.getElementById("portal-root")
        )
    }
}

export default DemoPortal

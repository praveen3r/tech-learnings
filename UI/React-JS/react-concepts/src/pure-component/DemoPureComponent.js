import React, { PureComponent } from 'react'

export class DemoPureComponent extends PureComponent {
    render() {
        console.log("Pure Component");
        return (
            <div>
                Pure Component {this.props.name}
            </div>
        )
    }
}

export default DemoPureComponent

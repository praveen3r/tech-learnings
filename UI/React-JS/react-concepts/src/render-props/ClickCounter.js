import React, { Component } from 'react'

export class ClickCounter extends Component {
    
    render() {
        const {count, onClickHandler} = this.props;
        return (
            <div>
                <button type="button" onClick={onClickHandler}>{this.props.name} Clicked {count} times</button>
            </div>
        )
    }
}

export default ClickCounter

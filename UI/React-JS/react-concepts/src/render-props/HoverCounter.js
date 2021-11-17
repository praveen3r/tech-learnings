import React, { Component } from 'react'

export class HoverCounter extends Component {

       
    render() {
        const {count, onClickHandler} = this.props;
        return (
            <div>
                <button type="button" onMouseOver={onClickHandler}>{this.props.name} Clicked {count} times</button>
            </div>
        )
    }
}

export default HoverCounter

import React, { Component } from 'react'
import withCounter from './WithCounter'

export class HoverCounterHOC extends Component {

       
    render() {
        const {count, onClickHandler} = this.props;
        return (
            <div>
                <button type="button" onMouseOver={onClickHandler}>{this.props.name} Clicked {count} times</button>
            </div>
        )
    }
}

export default withCounter(HoverCounterHOC, 3)

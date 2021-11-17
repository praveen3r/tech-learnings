import React, { Component } from 'react'
import withCounter from './WithCounter'

export class ClickCounterHOC extends Component {

   
    
    render() {
        const {count, onClickHandler} = this.props;
        return (
            <div>
                <button type="button" onClick={onClickHandler}>{this.props.name} Clicked {count} times</button>
            </div>
        )
    }
}

export default withCounter(ClickCounterHOC, 2)

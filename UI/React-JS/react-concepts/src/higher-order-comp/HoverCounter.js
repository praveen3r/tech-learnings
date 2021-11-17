import React, { Component } from 'react'

export class HoverCounter extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             count : 0
        }
    }

    onClickHandler = () => {
        this.setState( prevState => {
           return {
               count: prevState.count + 1
            } 
        })
    }
    
    render() {
        const {count} = this.state;
        return (
            <div>
                <button type="button" onMouseOver={this.onClickHandler}>Clicked {count} times</button>
            </div>
        )
    }
}

export default HoverCounter

import React, { Component } from 'react'

export class EventBind extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             message: 'Hello'
        }

        //this.onClickButton = this.onClickButton.bind(this);
    }

    // onClickButton(){
    //     this.setState({
    //         message: 'Welcome'
    //     })
    // }

    onClickButton = () => {
        this.setState({
            message: 'Welcome'
        })
    }
    

    render() {
        return (
            <div>
                <br/>{this.state.message}<br/>
                {/* <button onClick={this.onClickButton.bind(this)}>Click</button> 
                <button onClick={() => this.onClickButton()}>Click</button>*/}
                <button onClick={this.onClickButton}>Click</button>
            </div>
        )
    }
}

export default EventBind

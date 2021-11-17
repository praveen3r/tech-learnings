import React, { Component } from 'react'

export class ClassClick extends Component {

    onClickButton(){
        console.log("button clicked")
    }

    render() {
        return (
            <div>
               <div>
                    <button onClick={this.onClickButton}>Click me</button>
                 </div> 
            </div>
        )
    }
}

export default ClassClick

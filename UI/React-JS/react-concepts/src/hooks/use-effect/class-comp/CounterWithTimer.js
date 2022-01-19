import React, { Component } from 'react'

export class CounterWithTimer extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             count:0
        }
    }
    
    componentDidMount(){
      this.interval=setInterval(this.timerFunc, 1000)
    }

    componentWillUnmount(){
        clearInterval(this.interval);
    }

    timerFunc = () => {
        console.log("time func")
        this.setState( (prevState) => ({
            count: prevState.count + 1
        }))
    }

    render() {
        return (
            <div>
             <h2> {this.state.count}   </h2>
            </div>
        )
    }
}

export default CounterWithTimer

import React, { Component } from 'react'
import ChildComponent from './ChildComponent'
import DemoPureComponent from './DemoPureComponent'
import MemoComponent from './MemoComponent'

export class ParentComponent extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             name: 'Test'
        }
    }

    componentDidMount(){
        setInterval(() => {
            this.setState({
                name: 'Test'
            })
        },2000);
    }
    
    render() {
        console.log("*********Parent Component*************")
        return (
            <div>
                Parent Component
                {/* <ChildComponent name = {this.state.name}/>
                <DemoPureComponent name = {this.state.name}/> */}
                <MemoComponent name = {this.state.name}/>
            </div>
        )
    }
}

export default ParentComponent

import React, { Component } from 'react'
import ChildComponent from './ChildComponent';

export class ParentComponent extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             parentName : 'Parent'
        }

        this.parentMethod = this.parentMethod.bind(this);
        
    }

    parentMethod(ChildName){
        alert(`alert from ${ChildName} to ${this.state.parentName}`);
    }
    

    render() {
        return (
            <div>
                <ChildComponent parentHandler={this.parentMethod}></ChildComponent>
            </div>
        )
    }
}

export default ParentComponent

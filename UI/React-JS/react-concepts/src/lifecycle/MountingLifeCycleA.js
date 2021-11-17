import React, { Component } from 'react'
import MountingLifeCycleB from './MountingLifeCycleB';

export class MountingLifeCycleA extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             name:''
        }
        console.log("MountingLifeCycleA constructor");
    }

    static getDerivedStateFromProps(state, props){
        console.log("MountingLifeCycleA getDerivedStateFromProps");
        return null;
    }

    componentDidMount(){
        console.log("MountingLifeCycleA componentDidMount");
    }
    
    render() {
        console.log("MountingLifeCycleA render");
        return (
            <div>
                <p> hello from MountingLifeCycleA</p>
                <MountingLifeCycleB></MountingLifeCycleB>
            </div>
        )
    }
}

export default MountingLifeCycleA

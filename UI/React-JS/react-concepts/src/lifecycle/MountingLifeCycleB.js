import React, { Component } from 'react'

export class MountingLifeCycleB extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             name:''
        }
        console.log("MountingLifeCycleB constructor");
    }

    static getDerivedStateFromProps(state, props){
        console.log("MountingLifeCycleB getDerivedStateFromProps");
        return null;
    }

    componentDidMount(){
        console.log("MountingLifeCycleB componentDidMount");
    }
    
    render() {
        console.log("MountingLifeCycleB render");
        return (
            <div>
                <p> hello from MountingLifeCycleB</p>
            </div>
        )
    }
}

export default MountingLifeCycleB

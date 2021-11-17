import React, { Component } from 'react'

export class UpdatingLifeCycleB extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             name:''
        }
        console.log("UpdatingLifeCycleB constructor");
    }

    static getDerivedStateFromProps(state, props){
        console.log("UpdatingLifeCycleB getDerivedStateFromProps");
        return null;
    }

    shouldComponentUpdate(nextProps, nextState){
        console.log("UpdatingLifeCycleB shouldComponentUpdate");
        return true;
    }

    getSnapshotBeforeUpdate(prevProps, prevState){
        console.log("UpdatingLifeCycleB getSnapshotBeforeUpdate");
        return true;
    }

    componentDidUpdate(prevProps, prevState, snapshot){
        console.log("UpdatingLifeCycleB componentDidUpdate");
        return true;
    }

    changeState = event => {
        this.setState({
            name:''
        })
    }
    
    render() {
        console.log("UpdatingLifeCycleB render");
        return (
            <div>
                <p> hello from UpdatingLifeCycleB</p>
                
            </div>
        )
    }
}

export default UpdatingLifeCycleB

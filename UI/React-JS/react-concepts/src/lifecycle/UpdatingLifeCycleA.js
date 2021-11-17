import React, { Component } from 'react'
import UpdatingLifeCycleB from './UpdatingLifeCycleB';

export class UpdatingLifeCycleA extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             name:''
        }
        console.log("UpdatingLifeCycleA constructor");
    }

    static getDerivedStateFromProps(state, props){
        console.log("UpdatingLifeCycleA getDerivedStateFromProps");
        return null;
    }

    shouldComponentUpdate(nextProps, nextState){
        console.log("UpdatingLifeCycleA shouldComponentUpdate");
        return true;
    }

    getSnapshotBeforeUpdate(prevProps, prevState){
        console.log("UpdatingLifeCycleA getSnapshotBeforeUpdate");
        return null;
    }

    componentDidUpdate(prevProps, prevState, snapshot){
        console.log("UpdatingLifeCycleA componentDidUpdate");
        return null;
    }

    changeState = event => {
        this.setState({
            name:''
        })
    }
    
    render() {
        console.log("UpdatingLifeCycleA render");
        return (
            <div>
                <p> hello from UpdatingLifeCycleA</p>
                <button onClick={this.changeState}>Change state</button>
                <UpdatingLifeCycleB></UpdatingLifeCycleB>
            </div>
        )
    }
}

export default UpdatingLifeCycleA

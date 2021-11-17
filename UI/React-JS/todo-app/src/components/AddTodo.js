import React, { Component } from 'react'

export class AddTodo extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             value:''
        }

        this.OnChangeHandler = this.OnChangeHandler.bind(this);
        this.OnSubmitHandler = this.OnSubmitHandler.bind(this);
    }

    OnChangeHandler(e){
        this.setState({
            value: e.target.value
        })
    }

    OnSubmitHandler(e){
        e.preventDefault();
        this.props.onSubmitHandler(this.state.value);
    }
    
    render() {
        return (
            <>
                <form onSubmit={this.OnSubmitHandler}>
                    <div>
                        <input type="text" value = {this.state.value} onChange={this.OnChangeHandler}/>
                        <button type="submit">Add</button>
                    </div>
                </form>
            </>
        )
    }
}


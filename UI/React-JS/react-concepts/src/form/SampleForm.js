import React, { Component } from 'react'

export class SampleForm extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             txtVal: '12',
             dropDownVal: 'react'
        }
    }

    onChangeTextVal = event => {
        this.setState({
            txtVal: event.target.value,
             }
        )
    }

    onChangeDropDownVal = event => {
        this.setState({
            dropDownVal: event.target.value
            }
        )
    }

    onSubmitForm = event => {
        alert(`${this.state.txtVal} ${this.state.dropDownVal}`);
    }
    
    render() {
        return (
            <form onSubmit = {this.onSubmitForm}>
                <br/>
                <br/>
                <label>User</label><input type = "text" value = {this.state.txtVal} 
                                    onChange = {this.onChangeTextVal}/><br/>
                <label>Lang</label>
                <select value = {this.state.dropDownVal} onChange = {this.onChangeDropDownVal}>
                    <option value="react">react</option>
                    <option value="angular">angular</option>
                    <option value="vue">vue</option>
                </select><br/>
                <button type="submit">Submit</button>
            </form>
        )
    }
}

export default SampleForm

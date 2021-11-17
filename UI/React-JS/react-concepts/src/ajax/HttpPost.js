import React, { Component } from 'react'
import axios from 'axios'

export class HttpGet extends Component {

    constructor(props) {
        super(props)

        this.state = {
            userId: '',
            title: '',
            body: ''
        }
    }

    onClickSubmit = (event) => {
        event.preventDefault();
        axios.post('https://jsonplaceholder.typicode.com/posts', this.state)
            .then(response => {
                console.log(response);
                
            })
            .catch(error => {
                console.log(error);
            });
    }

    onChangeHandler = (event) => {
        this.setState({
            [event.target.name] : event.target.value
        })
    }

     

    render() {
        const { userId, title, body } = this.state;
        return (
            <div>
                <form>
                    <input type="text" name="userId" value={userId} 
                        onChange={this.onChangeHandler} />
                    <br />
                    <input type="text" name="title" value={title} 
                        onChange={this.onChangeHandler}/>
                    <br />
                    <input type="text" name="body" value={body} 
                        onChange={this.onChangeHandler}/>
                    <br />
                    <button type="submit" onClick={this.onClickSubmit}>submit</button>
                </form>
            </div>
        )
    }
}

export default HttpGet

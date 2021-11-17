import React, { Component } from 'react'
import axios from 'axios'

export class HttpGet extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             postList: []
        }
    }
    
    componentDidMount(){
        axios.get('https://jsonplaceholder.typicode.com/posts')
              .then(response => {
                console.log(response.data);
                this.setState({
                    postList : response.data
              })
            })
              .catch(error => {
                console.log(error);
              });
    }

    render() {
        const {postList} = this.state;
        return (
            <div>
                Post are
                {
                postList.length ? postList.map( post => <div>{post.id} - {post.title}</div>) : null
                }
            </div>
        )
    }
}

export default HttpGet

import React, {useState, useEffect} from 'react'
import axios from 'axios'

function DataFetching() {

    const [postList, setPosts] = useState([])

    useEffect(() => {
        axios.get('https://jsonplaceholder.typicode.com/posts')
        .then(response => {
          console.log(response.data);
          setPosts(response.data)
      })
        .catch(error => {
          console.log(error);
        });
    },[])
    
    return (
        <div>
             Post are
                {
                postList.length ? postList.map( post => <div>{post.id} - {post.title}</div>) : null
                }
        </div>
    )
}

export default DataFetching

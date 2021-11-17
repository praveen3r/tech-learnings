import React, {useState, useEffect} from 'react'
import axios from 'axios'

function DataFetching1() {

    const [post, setPost] = useState({});
    const [id, setId] = useState(1);
    const [idButton, setIdButton] = useState(1);

    useEffect(() => {
        axios.get(`https://jsonplaceholder.typicode.com/posts/${id}`)
        .then(response => {
          console.log(response.data);
          setPost(response.data)
      })
        .catch(error => {
          console.log(error);
        });
    },[idButton])

    const onClickHandler = () => {
        setIdButton(id);
    }

    return (
        <div>
            <input type="text" value={id} onChange={(e) => setId(e.target.value)}></input>
            <button type="button" onClick={onClickHandler}>Click</button><br/>

            {post.title}
            
        </div>
    )
}

export default DataFetching1

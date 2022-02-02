import React, { useState, useEffect } from 'react';
import httpClient from '../common/HttpClient';

function ApiCall() {

  const [postList, setPosts] = useState([])

  useEffect(() => {
    httpClient.get('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        console.log(response.data);
        setPosts(response.data)
      })
      .catch(error => {
        console.log(error);
      });
  }, [])

  return (
    <>
      Post are
      {
        postList.length ? postList.map(post => <div>{post.id} - {post.title}</div>) : null
      }
    </>
  );
}

export default ApiCall;

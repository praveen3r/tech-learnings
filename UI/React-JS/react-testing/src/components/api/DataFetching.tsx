import React, { useState, useEffect } from "react";
import axios from "axios";

function DataFetching() {
  const [postList, setPosts] = useState<any[]>([]);

  useEffect(() => {
    axios
      .get("https://jsonplaceholder.typicode.com/posts")
      .then((response) => {
        console.log(response.data);
        setPosts(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      Post are
      {postList.length
        ? postList.map((post) => (
            <li key={post.id}>
              {post.id} - {post.title}
            </li>
          ))
        : null}
    </div>
  );
}

export default DataFetching;

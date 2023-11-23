import React, { useState, useEffect } from "react";
import axios from "axios";

function ErrorHandling() {
  const [postList, setPosts] = useState<any[]>([]);
  const [error, setError] = useState("");

  useEffect(() => {
    axios
      .get("https://jsonplaceholder.typicode.com/posts")
      .then((response) => {
        console.log(response.data);
        setPosts(response.data);
      })
      .catch((error) => {
        setError("unexpected error");
      });
  }, []);

  return (
    <div>
      {error && <p>{error}</p>}
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

export default ErrorHandling;

import React, { useEffect, useState } from "react";

function Skills1(props: any) {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    setTimeout(() => {
      setIsLoggedIn(true);
    }, 1005);
  }, []);

  return (
    <>
      <ul>Skills are</ul>
      {props.data
        ? props.data.map((item: any) => <li key={item.id}>{item.name}</li>)
        : null}
      {isLoggedIn ? <button>Dashboard</button> : null}
    </>
  );
}

export default Skills1;

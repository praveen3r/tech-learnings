import React from "react";

function Skills(props: any) {
  return (
    <>
      <ul>Skills are</ul>
      {props.data
        ? props.data.map((item: any) => <li key={item.id}>{item.name}</li>)
        : null}
      {props.isLoggedIn ? <button>Dashboard</button> : null}
    </>
  );
}

export default Skills;

import React from 'react';
import {useNavigate, useSearchParams} from 'react-router-dom'

function Home() {
  const [searchParams, setSearchParams] = useSearchParams();
  const navigate = useNavigate();

  const onClickUsers = () => {
    setSearchParams({filter: 'Active'});
  }

  return (
    <>
  <div>Home</div>
  <button onClick={() => navigate('order-summary', {replace: true})}>Submit</button>
  <button onClick={() => onClickUsers()}>Go to users</button>
  </>
  );
}

export default Home;

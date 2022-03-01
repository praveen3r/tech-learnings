import React, { useState } from 'react'

type UserType = {
    firstName: string,
    lastName: string
}

export const UseStateType = () => {

  const [user, setUser] = useState<UserType | null>(null);

  const handleLogin = () => {
    setUser({
        firstName: 'Prav',
        lastName: 'Rajan'  
    })
  }

  const handleLogout = () => {
    setUser(null);
  }

  return (
      <>
    <button onClick={handleLogin}>Login</button>
    <button onClick={handleLogout}>Logout</button>
    <p>The user is {user !=null? user.firstName + ' ' + user.lastName: ''}</p>
    </>
  )
}

import { FaSignInAlt } from 'react-icons/fa';
import { Link, useNavigate } from 'react-router-dom'

import React from 'react'

function Header() {
  return (
    <header className='header'>
      <div className='logo'>
        <Link to='/dashboard'>Home</Link>
      </div>
      <ul>
        <li>
            <Link to='/login'>
            <FaSignInAlt /> Logout
            </Link>
        </li>
      </ul>
    </header>
  )
}

export default Header
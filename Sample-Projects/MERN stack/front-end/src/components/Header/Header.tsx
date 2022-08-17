import { FaSignInAlt } from 'react-icons/fa';
import { Link } from 'react-router-dom'

import React from 'react'
import DisplayMessage from '../i18n/DisplayMessage';

function Header() {
  return (
    <header className='header'>
      <div className='logo'>
        <Link to='/dashboard'><DisplayMessage id="home"/></Link>
      </div>
      <ul>
        <li>
            <Link to='/login'>
            <FaSignInAlt /> <DisplayMessage id="logout"/>
            </Link>
        </li>
      </ul>
    </header>
  )
}

export default Header
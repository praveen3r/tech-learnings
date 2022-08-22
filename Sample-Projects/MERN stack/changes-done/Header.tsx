import { FaSignInAlt } from 'react-icons/fa';
import { Link } from 'react-router-dom'

import React, { ChangeEvent, ChangeEventHandler, useState } from 'react'
import DisplayMessage from '../i18n/DisplayMessage';
import { dropdownOptions } from '../../types/FormTypes';

const Header = () => {

  const [value, setValue] = useState('en');

  const languageOptions: dropdownOptions[] = [
    { key: "en", value: "English" },
    { key: "de", value: "Germany" },
    { key: "fr", value: "French" },
  ];

  const handleChange = (event: ChangeEvent<HTMLSelectElement>) => {
    setValue(event.target.value);
  };

  return (
  <header className='header'>
      <div className='logo'>
        <Link to='/dashboard'><DisplayMessage id="home"/></Link>
      </div>
      <ul>
        <li>
        <select id="lang"name="lang" value={value} onChange={handleChange}>
          {/* <option key="" value="">
            Select Language
          </option> */}
          {languageOptions.map((option) => {
            return (
              <option key={option.key} value={option.key}>
                {option.value}
              </option>
            );
          })}
        </select>
        </li>
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
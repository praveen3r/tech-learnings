import { FaSignInAlt } from 'react-icons/fa';
import { Link } from 'react-router-dom'

import React, { ChangeEvent, ChangeEventHandler, useState } from 'react'
import DisplayMessage from '../i18n/DisplayMessage';
import { dropdownOptions } from '../../types/FormTypes';
import { useLang } from '../context/LangContent';

const Header = () => {

  const [value, setValue] = useState('en');

  const langContext = useLang();
  const dispatch = langContext!.dispatch;

  const languageOptions: dropdownOptions[] = [
    { key: "en", value: "English" },
    { key: "de", value: "Germany" },
    { key: "fr", value: "French" },
  ];

  const handleChange = (event: ChangeEvent<HTMLSelectElement>) => {
    const lang = event.target.value;
    setValue(lang);
    dispatch({type: 'setLocale', lang: lang});
    
  };

  return (
  <header className='header'>
      <div className='logo'>
        <Link to='/dashboard'><DisplayMessage id="home"/></Link>
      </div>
      <ul>
        <li>
        <select id="lang"name="lang" value={value} onChange={handleChange} className="lang-dropdown classic">
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
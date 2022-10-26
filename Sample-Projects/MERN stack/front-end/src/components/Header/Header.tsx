import { FaSignInAlt } from 'react-icons/fa';

import React, { ChangeEvent, useState } from 'react'
import { dropdownOptions } from '../../types/FormTypes';
import { useLang } from '../context/LangContent';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../context/Auth';

const Header = () => {

  const [value, setValue] = useState('en');
  const navigate = useNavigate();
  const auth = useAuth();

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

  const logOut = () => {
    auth!.logout();
    navigate("/login");
  }

  return (
  <header className='header'>
     
      <div className='logo'>
        
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
            <FaSignInAlt style={{marginTop:10}}/><Button variant="link" onClick={() => logOut()}>Logout</Button>
                              
                            
        </li>
      </ul>
    </header>
  )
}

export default Header
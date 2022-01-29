import React from 'react';
import {NavLink} from 'react-router-dom'
import { useAuth } from './Auth';

function NavbarWithNavLink() {
    const auth = useAuth();
    
    return (
    <nav>
        <NavLink to='/'>Home</NavLink>
        <NavLink to='/about'>About</NavLink>
        <NavLink to='/products'>Products</NavLink>
        <NavLink to='/users'>Users</NavLink>
        <NavLink to='/profile'>Profile</NavLink>
        {
            !auth.user && (
                <NavLink to='/login'>Login</NavLink>
            )
        }
    </nav>
    );
}

export default NavbarWithNavLink;

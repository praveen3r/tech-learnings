import React from 'react';
import {Link} from 'react-router-dom'
import { useAuth } from './Auth';

function Navbar() {
    const auth = useAuth();
    
    return (
    <nav>
        <Link to='/'>Home</Link>
        <Link to='/about'>About</Link>
        <Link to='/products'>Products</Link>
        <Link to='/users'>Users</Link>
        <Link to='/profile'>Profile</Link>
        {
            !auth.user && (
                <Link to='/login'>Login</Link>
            )
        }
    </nav>
    );
}

export default Navbar;

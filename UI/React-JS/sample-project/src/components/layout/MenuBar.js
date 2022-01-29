import React from 'react';
import { Navigate, NavLink } from 'react-router-dom';
import { useAuth } from './../../util/Auth';

function MenuBar() {
    const auth = useAuth();

    return (
        <>
            {

                auth && auth.user && (
                    <nav>
                        <NavLink to='/about'>Dashboard</NavLink>
                    </nav>

                )}
        </>
    )
}

export default MenuBar;

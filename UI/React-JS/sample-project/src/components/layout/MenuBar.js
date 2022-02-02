import React from 'react';
import { Navigate, NavLink, useNavigate } from 'react-router-dom';
import { useAuth } from './../../util/Auth';

function MenuBar() {
    const navigate = useNavigate();
    const auth = useAuth();

    const logout = () => {
        auth.logout();
        navigate('');
    }

    return (
        <>
            {

                auth && auth.user && (
                    <>
                        <div className="card">
                            <div className="card-header" >
                                <div className="row">
                                    <span className="col-xs-1 col-sm-1 col-md-1 col-lg-1">Img</span>
                                    <span className="col-xs-10 col-sm-9 col-md-10 col-lg-10" align="center">
                                        Good Morning, {auth.user.username}</span>
                                    <span className="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                                        <a style={{color:"#23527c",textDecoration:"underline",cursor: "pointer"}} onClick={logout}>Log out</a></span>
                                </div>
                            </div>
                            <div className="card-body" >
                                <nav>
                                    <NavLink to='/grid'>Grid</NavLink>
                                    <NavLink to='/form'>Form</NavLink>
                                    <NavLink to='/search'>Search</NavLink>
                                    <NavLink to='/others'>Others</NavLink>
                                    <NavLink to='/bootstrap-comp'>Bootstrap comp</NavLink>
                                    <NavLink to='/material-ui-comp'>Material UI comp</NavLink>
                                    <NavLink to='/api-call'>API call</NavLink>
                                </nav>
                            </div>
                        </div>
                    </>
                )}
        </>
    )
}

export default MenuBar;

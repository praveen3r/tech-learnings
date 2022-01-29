import React from 'react';
import { Route } from 'react-router-dom';
import Dashboard from '../components/dashboard/Dashboard';
import InvalidRoute from '../components/route/InvalidRoute';
import Login from '../components/login/Login';
import RouteAuth from '../components/route/RouteAuth';

export const routes = [
    { path: '', component: <RouteAuth isAuthRequired="false"><Login/></RouteAuth> },
    { path: 'login', component: <RouteAuth><Login/></RouteAuth> },
    { path: 'dashboard', component: <RouteAuth><Dashboard/> </RouteAuth>},
    { path: '*', component: <RouteAuth><InvalidRoute/></RouteAuth> }
];


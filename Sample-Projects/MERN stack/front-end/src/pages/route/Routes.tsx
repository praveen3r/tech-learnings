import React from 'react';
import Dashboard from '../Dashboard';
import InvalidRoute from './InvalidRoute';
import Login from '../Login'
import { RouteType } from '../../types/ComponentType';


export const routes: RouteType[] = [
    { path: '', component: <Login /> },
    { path: 'login', component: <Login /> },
    { path: 'dashboard', component:  <Dashboard/> },
    { path: '*', component: <InvalidRoute/> }
];


import React from 'react';
import Dashboard from '../Dashboard';
import InvalidRoute from './InvalidRoute';
import { RouteType } from '../../types/ComponentType';


export const routes: RouteType[] = [
    { path: 'dashboard', component:  <Dashboard/> },
    { path: '*', component: <InvalidRoute/> }
];


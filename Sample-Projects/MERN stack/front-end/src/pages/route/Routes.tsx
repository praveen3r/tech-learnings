import React from 'react';
import Dashboard from '../Dashboard';
import InvalidRoute from './InvalidRoute';
import { RouteType } from '../../types/ComponentType';
import UserSearch from '../../components/home/UserSearch';
import HomeWithGrid from '../../components/home/HomeWithGrid';


export const routes: RouteType[] = [
    { path: 'dashboard', component:  <HomeWithGrid/> },
    { path: 'search', component:  <UserSearch/> },
    { path: '*', component: <InvalidRoute/> }
];


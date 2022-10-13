import React from 'react';
import InvalidRoute from './InvalidRoute';
import { RouteType } from '../../types/ComponentType';
import UserSearch from '../search/UserSearch';
import HomeWithGrid from '../home/HomeWithGrid';


export const routes: RouteType[] = [
    { path: 'dashboard', component:  <HomeWithGrid/> },
    { path: 'search', component:  <UserSearch/> },
    { path: '*', component: <InvalidRoute/> }
];


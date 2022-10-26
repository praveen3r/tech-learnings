import React from 'react';
import InvalidRoute from './InvalidRoute';
import { RouteType } from '../../types/ComponentType';
import UserSearch from '../search/UserSearch';
import HomeWithGrid from '../home/HomeWithGrid';
import Download from '../download/Download';


export const routes: RouteType[] = [
    { path: 'dashboard', component:  <HomeWithGrid/> },
    { path: 'search', component:  <UserSearch/> },
    { path: 'download', component:  <Download/> },
    { path: '*', component: <InvalidRoute/> }
];


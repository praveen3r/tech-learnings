import React from 'react';
import { Route } from 'react-router-dom';
import Dashboard from '../components/dashboard/Dashboard';
import InvalidRoute from '../components/route/InvalidRoute';
import Login from '../components/login/Login';
import RouteAuth from '../components/route/RouteAuth';
import Grid from '../components/grid/Grid';
import { Form } from 'formik';
import Forms from '../components/form/Form';
import Search from '../components/search/Search';
import Others from '../components/others/Others';
import ApiCall from '../components/api/ApiCall';
import BootstrapComp from '../components/bootstrap/BootstrapComp';

export const routes = [
    { path: '', component: <RouteAuth isAuthRequired="false"><Login/></RouteAuth> },
    { path: 'login', component: <RouteAuth><Login/></RouteAuth> },
    { path: 'grid', component: <RouteAuth><Grid/> </RouteAuth>},
    { path: 'form', component: <Forms/> },
    { path: 'search', component: <RouteAuth><Search/> </RouteAuth>},
    { path: 'others', component: <RouteAuth><Others/> </RouteAuth>},
    { path: 'bootstrap-comp', component: <RouteAuth><BootstrapComp/> </RouteAuth>},
    { path: 'api-call', component: <RouteAuth><ApiCall/> </RouteAuth>},
    { path: '*', component: <RouteAuth><InvalidRoute/></RouteAuth> }
];


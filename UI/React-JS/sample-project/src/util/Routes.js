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
import MaterialUiComp from '../components/material-ui/MaterialUiComp';

export const routes = [
    { path: '', component: <RouteAuth isAuthRequired="false"><Login/></RouteAuth> },
    { path: 'login', component: <RouteAuth><Login/></RouteAuth> },
    { path: 'grid', component: <RouteAuth><Grid/> </RouteAuth>},
    { path: 'form', component: <RouteAuth><Forms/></RouteAuth> },
    { path: 'search', component: <Search/>},
    { path: 'others', component: <Others/>},
    { path: 'bootstrap-comp', component: <RouteAuth><BootstrapComp/> </RouteAuth>},
    { path: 'material-ui-comp', component: <RouteAuth><MaterialUiComp/> </RouteAuth>},
    { path: 'api-call', component: <RouteAuth><ApiCall/> </RouteAuth>},
    { path: '*', component: <RouteAuth><InvalidRoute/></RouteAuth> }
];


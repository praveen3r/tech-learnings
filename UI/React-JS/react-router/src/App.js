import React from 'react';
import './App.css';
import { Routes, Route } from 'react-router-dom'
import Home from './components/Home';
//import About from './components/About';
import { NoMatchRoute } from './components/NoMatchRoute';
import NavbarWithNavLink from './components/NavbarWithNavLink';
import { OrderSummary } from './components/OrderSummary';
import Products from './components/Products';
import { FeaturedProducts } from './components/FeaturedProducts';
import { NewProducts } from './components/NewProducts';
import { UserAdmin } from './components/UserAdmin';
import Users from './components/Users';
import { UserDetails } from './components/UserDetails';
import Profile from './components/Profile';
import Login from './components/Login';
// import Navbar from './components/Navbar';
import { AuthProvider } from './components/Auth';
import RequireAuth from './components/RequireAuth';
const LazyAbout = React.lazy(() => import('./components/About'));


function App() {
  return (
    <>
      {/* <Navbar/> */}
      <AuthProvider>
        <NavbarWithNavLink />
        <Routes>
          <Route path='/' element={<Home />}></Route>
          <Route path='about' element={<React.Suspense fallback="Loading..."><LazyAbout /></React.Suspense>}></Route>
          <Route path='products' element={<Products />}>
            <Route index element={<FeaturedProducts />}></Route>
            <Route path='featured' element={<FeaturedProducts />}></Route>
            <Route path='new' element={<NewProducts />}></Route>
          </Route>
          <Route path='order-summary' element={<OrderSummary />}></Route>
          {/* <Route path='users' element={<Users />}></Route>
        <Route path='users/:userId' element={<UserDetails />}></Route>
        <Route path='users/admin' element={<UserAdmin/>}></Route> */}
          <Route path='users' element={<Users />}>
            <Route path=':userId' element={<UserDetails />}></Route>
            <Route path='admin' element={<UserAdmin />}></Route>
          </Route>

          <Route path='profile' element={<RequireAuth><Profile /></RequireAuth>}></Route>
          <Route path='login' element={<Login />}></Route>
          <Route path='*' element={<NoMatchRoute />}></Route>

        </Routes>
      </AuthProvider>
    </>
  );
}

export default App;

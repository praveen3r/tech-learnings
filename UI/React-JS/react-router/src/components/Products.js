import React from 'react';
import { Link, Outlet } from 'react-router-dom';

function Products() {
    return (
        <>
        <div>Products page</div>
        <Link to='featured'>Featured</Link>
        <Link to='new'>New</Link>
        <Outlet/>
        </>
    );
}

export default Products;

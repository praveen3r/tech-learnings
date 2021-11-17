import React from 'react'

const JSX = () => {
   // return <h1>Hello from JSX</h1>
   return React.createElement('div', {id : 'test', className: 'dummy'}, 
            React.createElement('h1',null, 'Hello from JSX'));
}

export default JSX;
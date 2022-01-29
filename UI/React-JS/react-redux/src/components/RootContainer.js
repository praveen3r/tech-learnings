import React from 'react';
import { useDispatch, useSelector } from 'react-redux'
import cakeAction from '../cake/Action';
import iceCreamAction from '../ice-cream/Action';

function RootContainer() {

  const cake = useSelector(state => state.cake)
const iceCream = useSelector(state => state.iceCream)
    const dispatch = useDispatch();

    return <div>
        <div>
            Number of cakes - {cake.numOfCakes}
        </div>
        <div>
            <button onClick={() => dispatch(cakeAction())}>Buy Cake </button>
        </div>
        <br/>
        <br/>
        <div>
            Number of ice cream - {iceCream.numOfIceCream}
        </div>
        <div>
            <button onClick={() => dispatch(iceCreamAction())}>Buy icecream </button>
        </div>
    </div>;
}



export default RootContainer;

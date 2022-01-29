import React from 'react';
import { useDispatch, useSelector } from 'react-redux'
import cakeAction from '../../cake/Action';

function Demo() {
    const numOfCakes = useSelector(state => state.numOfCakes)
    const dispatch = useDispatch();
    
    return <div>
        <div>
            Number of cakes - {numOfCakes}
        </div>
        <div>
            <button onClick={() => dispatch(cakeAction())}>Buy Cake </button>
        </div>
    </div>;
}

export default Demo;

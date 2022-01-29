import React from 'react';
import { useSelector } from 'react-redux'

function Demo() {
    const numOfCakes = useSelector(state => state.numOfCakes)
    return <div>
        <div>
            Number of cakes - {numOfCakes}
        </div>
        <div>
            <button>Buy Cake </button>
        </div>
    </div>;
}

export default Demo;

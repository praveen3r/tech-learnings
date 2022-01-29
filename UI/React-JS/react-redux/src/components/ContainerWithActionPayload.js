import React, {useState} from 'react';
import { useDispatch, useSelector } from 'react-redux'
import newCakeAction from '../cake-with-action-payload/Action';

function ContainerWithActionPayload() {

 const [number, setNumber] = useState(0);
  const numOfCakes = useSelector(state => state.numOfCakes)
    const dispatch = useDispatch();

    return <div>
        <div>
            Number of cakes - {numOfCakes}
        </div>
        <div>
            <input type="text" state={number} onChange={e => setNumber(e.target.value)}/>
        </div>
        <div>
            <button onClick={() => dispatch(newCakeAction(number))}>Buy Cake </button>
        </div>
       
    </div>;
}



export default ContainerWithActionPayload;

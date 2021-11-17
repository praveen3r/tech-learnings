
import React,{useReducer} from 'react'

function CounterTwo() {

    const initialState = {
        firstCount : 0,
        secondCount : 100
    };

    const reducer = (state, action) => {
        switch(action.type){
            case 'increment':
                return {...state, firstCount : state.firstCount + action.value };
            case 'decrement':
                return {...state,firstCount : state.firstCount - action.value };
            case 'increment2':
                return {...state,secondCount : state.secondCount + action.value };
            case 'decrement2':
                return {...state,secondCount : state.secondCount - action.value };
            case 'reset':
                return initialState;
            default:
                return state;
        }
    }

    const [count, dispatch] = useReducer(reducer, initialState);

    return (
        <div>
            Count is {count.firstCount}<br/>
            Count is {count.secondCount}
            <br/>
            <button onClick={() => dispatch({type: 'increment', value: 1})}>increment</button>
            <button onClick={() => dispatch({type:'decrement', value: 1})}>decrement</button>
            <button onClick={() => dispatch({type: 'increment', value: 5})}>increment 5</button>
            <button onClick={() => dispatch({type:'decrement', value: 5})}>decrement 5</button>
            <button onClick={() => dispatch({type: 'increment2', value: 1})}>increment Two</button>
            <button onClick={() => dispatch({type:'decrement2', value: 1})}>decrement Two</button>
            <button onClick={() => dispatch({type:'reset'})}>reset</button>
        </div>
    )
}

export default CounterTwo

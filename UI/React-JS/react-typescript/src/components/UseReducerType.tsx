import React, { useReducer } from 'react'

const UseReducerType  = () => {

    const initialState = {
        count : 0
    };

    type stateType = {
        count: number
    }

    type updateAction = {
        type: 'increment' | 'decrement',
        value: number
    }

    type resetAction = {
        type: 'reset',
    }

    type actionType = updateAction | resetAction;

    const reducer = (state: stateType, action: actionType) => {
        switch(action.type){
            case 'increment':
                return {...state, count : state.count + action.value };
            case 'decrement':
                return {...state, count : state.count - action.value };
            case 'reset':
                return initialState;
            default:
                return state;
        }
    }

    const [count, dispatch] = useReducer(reducer, initialState);

    return (
        <div>
            Count is {count.count}<br/>
            <br/>
            <button onClick={() => dispatch({type: 'increment', value: 1})}>increment</button>
            <button onClick={() => dispatch({type:'decrement', value: 1})}>decrement</button>
            <button onClick={() => dispatch({type: 'increment', value: 5})}>increment 5</button>
            <button onClick={() => dispatch({type:'decrement', value: 5})}>decrement 5</button>
            <button onClick={() => dispatch({type:'reset'})}>reset</button>
        </div>
    )
}

export default UseReducerType
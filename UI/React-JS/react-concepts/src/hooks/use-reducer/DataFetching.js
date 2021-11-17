import React, {useReducer, useEffect} from 'react'
import axios from 'axios'

function DataFetching() {

    const initialState = {
        error: '',
        post: {}
    }

    const reducer = (state, action) => {
        switch(action.type){
            case 'SUCCESS':
             return {
                error: '',
                post: action.payload
             }
            case 'ERROR':
            return {
                error: 'Something went wrong',
                post: {}
             }
            default:
             return state;
        }
    }

    const [state, dispatch] = useReducer(reducer, initialState);

    useEffect(() => {
        axios.get('https://jsonplaceholder.typicode.com/posts/1')
        .then(response => {
            dispatch({type : 'SUCCESS', payload: response.data})
      })
        .catch(error => {
            dispatch({type : 'ERROR'})
        });
    },[])
    
    return (
        <div>
             
                { state.post.title }
        </div>
    )
}

export default DataFetching

import React from 'react'

function ChildComponent(props) {
    return (
        <div>
            <button onClick={()=> props.parentHandler('Child')}>Child button</button>
        </div>
    )
}

export default ChildComponent

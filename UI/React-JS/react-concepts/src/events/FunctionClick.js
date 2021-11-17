import React from 'react'

function FunctionClick() {

    function onClickButton(){
        console.log("button clicked")
    }

    return (
        <div>
            <button onClick={onClickButton}>Click me</button>
        </div>
    )
}

export default FunctionClick

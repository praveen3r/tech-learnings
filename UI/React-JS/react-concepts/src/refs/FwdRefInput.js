import React, { Component } from 'react'

const FwdRefInput = React.forwardRef((pros,ref) => {
        return (
            <div>
                <input type="text" ref={ref}/>
            </div>
        )
    })


export default FwdRefInput

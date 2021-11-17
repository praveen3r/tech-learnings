import React from 'react'

function InlineStyling() {
    const inlineStyles = {
        fontSize : '40px' //must be camel case
    }
    return (
        <div>
            <p style={inlineStyles}>Internal styling</p>
        </div>
    )
}

export default InlineStyling

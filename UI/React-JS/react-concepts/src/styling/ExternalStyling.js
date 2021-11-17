import React from 'react'
import './external.css';

function ExternalStyling(props) {
    const isColorReq = props.isColorReq ? 'extern' : ''
    return (
        <div>
            {/* <p className="extern">ExternalStyling</p> */}
            <p className={isColorReq}>ExternalStyling</p>
        </div>
    )
}

export default ExternalStyling

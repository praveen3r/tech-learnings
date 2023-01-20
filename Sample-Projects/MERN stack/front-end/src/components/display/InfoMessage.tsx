import React from "react";

const InfoMessage = (props: any) => {
    return (
      <div>
       <div className='text-info message-margin'> 
            {props.children}
        </div>
      </div>
    )};

export default InfoMessage;

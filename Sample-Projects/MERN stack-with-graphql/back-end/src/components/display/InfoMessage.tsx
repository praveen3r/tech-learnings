import React from "react";
import { ChildrenType } from "../../types/ComponentType";

const InfoMessage = (props: ChildrenType) => {
    return (
      <div>
       <div className='text-info message-margin'> 
            {props.children}
        </div>
      </div>
    )};

export default InfoMessage;

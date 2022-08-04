import React from "react";

const TextError: React.ComponentType<{}> = (props: any) => {
    return (
      <div>
       <div className="errorText"> 
            {props.children}
        </div>
      </div>
    )};

export default TextError;

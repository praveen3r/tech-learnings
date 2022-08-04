import React from "react";
import TextInput from "./TextInput";
import { InputType } from "../../types/FormTypes";

function InputComponent(props: InputType) {
  const { dataType } = props;
  switch (dataType) {
    case "password":
      return (
        <TextInput
          {...props}
          className="form-control"
          onPaste={(e: React.ClipboardEvent) => {
            e.preventDefault();
            return false;
          }}
        />
      );
    case "number":
      return <TextInput {...props} className="form-control" />
      //return <NumberInput {...props} className="form-control"/>
    default:
      return <TextInput {...props} className="form-control" />;
  }
}

export default InputComponent;

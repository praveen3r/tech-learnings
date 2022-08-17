import { ErrorMessage, Field } from "formik";
import React from "react";
import { InputType } from "../../types/FormTypes";
import DisplayMessage from "../i18n/DisplayMessage";
import TextError from "./TextError";

function TextInput(props: InputType) {
  const { label, type, id, name, ...rest } = props;
  const placeholder = "Enter " + label;
  return (
    <>
      <div>
        {/* <label htmlFor={name}>{label}:</label> */}
        <label htmlFor={name}> <DisplayMessage id={label}/>:</label>
        <Field
          type={type}
          id={id}
          name={name}
          placeholder={placeholder}
          autoComplete="false"
          {...rest}
        />

        <ErrorMessage name={name} component={TextError} />
      </div>
    </>
  );
}

export default TextInput;

import { ErrorMessage, Field } from "formik";
import React from "react";
import { InputType } from "../../types/FormTypes";
import TextError from "./TextError";

function TextInput(props: InputType) {
  const { label, type, id, name, ...rest } = props;
  const placeholder = "Enter " + label;
  return (
    <>
      <div>
        <label htmlFor={name}>{label}:</label>
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

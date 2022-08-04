import { ErrorMessage, Field } from "formik";
import React from "react";
import { InputType } from "../../types/FormTypes";
import TextError from "./TextError";

const setFieldValue = (event: any, handleChange:any) => {
  console.log(`coming here`);
  
  const value = event.target.value;
  const transformedInput = value.replace(/[^0-9]*/gi, "");
  event.target.value = transformedInput;
  handleChange(event);
}

function NumberInput(props: InputType) {
  const { label, id, name } = props;
  const placeholder = "Enter " + label;
  return (
    <>
      <div>
        <label htmlFor={name}>{label}:</label>
        <input
          type="text"
          name={name}
          id={id}
          autoComplete="false"
          placeholder={placeholder}
          {...props.formik.field}
          onChange={e => {
            setFieldValue(e, props.formik.handleChange);
          }}
        />

        <ErrorMessage name={name} component={TextError} />
      </div>
    </>
  );
}

export default NumberInput;

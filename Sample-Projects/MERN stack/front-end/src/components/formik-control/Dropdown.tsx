import { ErrorMessage, Field } from "formik";
import React from "react";
import { DropdownType } from "../../types/FormTypes";
import TextError from "./TextError";

function Dropdown(props: DropdownType) {
  const { label, id, name, options, ...rest } = props;

  return (
    <>
        <label htmlFor={name}>{label}:</label>
        <Field as="select" id={id} name={name} {...rest} className="classic">
          <option key="" value="">
            Select {label}
          </option>
          {options.map((option) => {
            return (
              <option key={option.key} value={option.key}>
                {option.value}
              </option>
            );
          })}
        </Field>

        <ErrorMessage name={name} component={TextError} />
    </>
  );
}

export default Dropdown;

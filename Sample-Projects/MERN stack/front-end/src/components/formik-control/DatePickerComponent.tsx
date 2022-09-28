import React from "react";
import TextInput from "./TextInput";
import { InputType } from "../../types/FormTypes";
import { ErrorMessage, Field } from "formik";
import TextError from "./TextError";
import DateView from 'react-datepicker'
import 'react-datepicker/dist/react-datepicker.css'
import DisplayMessage from "../i18n/DisplayMessage";

function DatePickerComponent(props: any) {
  const { label, name, ...rest } = props;
    return (

        <div>
            <label htmlFor={name}><DisplayMessage id={label}/>:</label>
            <Field name={name}>
                {
                    ({ form, field } : any) => {
                        const { setFieldValue } = form
                        const { value } = field
                        return <DateView id={name} {...field} {...rest} selected={value}
                         onChange={(val: any) => setFieldValue(name, val)}/>
                    }
                }
            </Field>
            <ErrorMessage name={name} component={TextError} />
        </div>);
}

export default DatePickerComponent;

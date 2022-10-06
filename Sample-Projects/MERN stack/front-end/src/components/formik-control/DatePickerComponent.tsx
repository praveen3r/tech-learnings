import React from "react";
import { DatePickerType,} from "../../types/FormTypes";
import { ErrorMessage, Field } from "formik";
import TextError from "./TextError";
import DateView from 'react-datepicker'
import 'react-datepicker/dist/react-datepicker.css'
import DisplayMessage from "../i18n/DisplayMessage";
import { useIntl } from "react-intl";

function DatePickerComponent(props: DatePickerType) {
  const { label, name, ...rest } = props;
  const intl  = useIntl();
  const placeholder = intl.formatMessage({id: 'enter'}) + ' ' + intl.formatMessage({id: label});
    return (

        <div>
            <label htmlFor={name}><DisplayMessage id={label}/>:</label>
            <Field name={name}>
                {
                    ({ form, field } : any) => {
                        const { setFieldValue } = form
                        const { value } = field
                        return <DateView {...field} {...rest} id={name} selected={value}
                         onChange={(val: any) => setFieldValue(name, val)} placeholderText={placeholder}
                         />
                    }
                }
            </Field>
            <ErrorMessage name={name} component={TextError} />
        </div>);
}

export default DatePickerComponent;

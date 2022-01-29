import React from 'react';
import { ErrorMessage, Field } from 'formik';
import TextError from './TextError';

function CheckBox(props) {
    const { label, id, name, options, ...rest } = props;
    return (
        <>
            <div>
                <label htmlFor={name}>{label}:</label>
                <Field name={name}
                    {...rest} >
                    {
                ({field}) => {
                  return (
                        options.map(option => {
                            return (
                            <React.Fragment key={option.key}>
                             <input type='checkbox' id={option.key} {...field} value={option.key}  />
                             <label htmlFor={option.key}>{option.value}</label>
                            </React.Fragment>
                            )
                        })
                  )
                }
              }
                </Field>

                <ErrorMessage name={name} component={TextError} />
            </div>
        </>);
}

export default CheckBox;

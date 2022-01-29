import { ErrorMessage, Field } from 'formik';
import React from 'react';
import TextError from './TextError';

function DropDown(props) {
    const { label, id, name, options, ...rest } = props;
    return (
        <>
            <div>
                <label htmlFor={name}>{label}:</label>
                <Field as='select'
                    id={id} name={name}
                    {...rest} >
                    {
                        options.map(option => {
                            return <option key={option.key} value={option.key}>{option.value}</option>
                        })
                    }
                </Field>

                <ErrorMessage name={name} component={TextError} />
            </div>
        </>);
}

export default DropDown;

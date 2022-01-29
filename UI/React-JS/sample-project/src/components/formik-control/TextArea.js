import React from 'react';
import { ErrorMessage, Field } from 'formik';
import TextError from './TextError';

function TextArea(props) {
    const {label, type, id, name, ...rest } = props;
    return (
    <>
       <div>
       <label htmlFor={name}>{label}:</label>
        <Field as='textarea'
            id={id} name={name}
            {...rest} />

        <ErrorMessage name={name} component={TextError}/>
        </div>
    </>);
}

export default TextArea;

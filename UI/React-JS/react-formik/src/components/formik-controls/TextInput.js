import { ErrorMessage, Field } from 'formik';
import React from 'react';
import TextError from './TextError';

function TextInput(props) {
    const {label, type, id, name, ...rest } = props;
    return (
    <>
    <div>
       <label htmlFor={name}>{label}:</label>
        <Field type={type}
            id={id} name={name}
            {...rest} />

        <ErrorMessage name={name} component={TextError}/>
        </div>
    </>);
}

export default TextInput;

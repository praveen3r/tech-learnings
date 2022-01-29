import React from 'react';
import { Formik, Form, Field } from 'formik'
import * as Yup from 'yup'
import FormikComponent from '../formik-controls/FormikComponent'

const initialValues = {
    username: '',
    password: '',
}

const validationSchema = Yup.object({
    username: Yup.string().required("username is required"),
    password: Yup.string().required("password is required")
})

const onSubmit = values => {
    console.log(values)
}

function LoginForm() {
    return (
        <>
            <Formik initialValues={initialValues}
                validationSchema={validationSchema}
                onSubmit={onSubmit}>
                {
                    formik =>
                        <Form>
                            <FormikComponent control="input" label="Username" type="text" id="username" name="username" maxLength="15" />
                            
                            <FormikComponent control="input" label="Password" type="password" id="password" name="password" maxLength="15" />

                            <button type="submit">Submit</button>
                        </Form >

                }

            </Formik>
        </>
    )
}

export default LoginForm;

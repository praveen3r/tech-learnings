import React from 'react';
import { Formik, Form, Field } from 'formik'
import * as Yup from 'yup'
import FormikComponent from '../formik-control/FormikComponent'
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../../util/Auth';
import Button from 'react-bootstrap/Button'

const initialValues = {
  username: '',
  password: '',
}

const validationSchema = Yup.object({
  username: Yup.string().required("username is required"),
  password: Yup.string().required("password is required")
})

function Login() {

  const navigate = useNavigate();
  const auth = useAuth();

  const onSubmit = values => {
    auth.login(values);
    navigate('/grid')
  }

  return (
    <>
        <Formik initialValues={initialValues}
            validationSchema={validationSchema}
            onSubmit={onSubmit}>
            {
                formik =>
                    <Form>
                        <FormikComponent control="input" label="Username" type="text" id="username"
                         name="username" maxLength="15" />
                        
                        <FormikComponent control="input" label="Password" type="password" id="password" 
                        name="password" maxLength="15" />

                        <Button type="submit">Submit</Button>
                        <Button type="button" variant="secondary">Clear</Button>
                    </Form >

            }

        </Formik>
    </>
)
}

export default Login

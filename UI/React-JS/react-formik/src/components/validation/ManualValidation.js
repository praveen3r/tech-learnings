import React from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik'
import * as Yup from 'yup'

const initialValues = {
  name: 'test',
  email: ''
}

const validationSchema = Yup.object({
  name: Yup.string().required("Name is required"),
  email: Yup.string().required("Email is required").email("Invalid email")
})

const onSubmit = values => {
  console.log(values)
}

const validateEmail = (emailValue) => {
  let error;
  if (!emailValue) {
    error = "Email is required"
  }
  return error;
}

function ManualValidation() {

  return (
    <>
      <Formik initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={onSubmit}
        validateOnChange={false}
        validateOnBlur={false}>
        {
          formik => {
            return (
              <Form>
                <div>
                  <label htmlFor="name" >Name</label>
                  <Field type="text"
                    id="name" name="name"
                    maxLength="15" autoComplete="off"
                    placeholder="Enter Name" />

                  <ErrorMessage name='name' />
                </div>
                <div>
                  <label htmlFor="email" >Email</label>
                  <Field type="text"
                    id="email" name="email"
                    maxLength="15" autoComplete="off"
                    placeholder="Enter Email" validate={validateEmail} />

                  <ErrorMessage name='email' />
                </div>
                <br />
                <div>

                  <button type="submit"  >Submit</button>
                  <button type="button" onClick={() => formik.validateField('email')}> validate Email</button>
                  <button type="button" onClick={() => formik.validateForm()}> validate All</button>

                </div>
              </Form >
            )
          }
        }
      </Formik>
    </>
  )
}

export default ManualValidation

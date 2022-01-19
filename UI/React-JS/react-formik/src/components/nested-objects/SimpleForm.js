import React from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik'
import * as Yup from 'yup'

const initialValues = {
  name: 'test',
  email: '',
  social: {
    facebook: '',
    twitter: ''
  }
}

const validationSchema = Yup.object({
  name: Yup.string().required("Name is required"),
  email: Yup.string().required("Email is required").email("Invalid email")
})

const onSubmit = values => {
  console.log(values)
}

function SimpleForm() {

  return (
    <>
      <Formik initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={onSubmit}>
        <Form>
          <div>
            <label htmlFor="userid" >Name</label>
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
              placeholder="Enter Email" />

            <ErrorMessage name='email' />
          </div>
          <div>
            <label htmlFor="social.facebook" >Facebook Id</label>
            <Field type="text"
              id="facebook" name="social.facebook"
              maxLength="15" autoComplete="off"
              placeholder="Enter Facebook Id" />

            <ErrorMessage name='social.facebook' />
          </div>
          <div>
            <label htmlFor="social.twitter" >Twitter Id</label>
            <Field type="text"
              id="twitter" name="social.twitter"
              maxLength="15" autoComplete="off"
              placeholder="Enter Twitter Id" />

            <ErrorMessage name='social.twitter' />
          </div>
          <br />
          <div>
            <button type="submit"  >Submit</button>
            <button type="button" > Clear</button >
          </div>
        </Form >
      </Formik>
    </>
  )
}

export default SimpleForm

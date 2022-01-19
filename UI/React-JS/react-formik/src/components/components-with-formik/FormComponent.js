import React from 'react'
import {Formik, Form} from 'formik'
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

function FormComponent() {

  return (
    <>
      <Formik initialValues={initialValues} 
              validationSchema={validationSchema}
              onSubmit={onSubmit}>
        <Form>
          <div>
            <label htmlFor="userid" >Name</label>
            <input type="text"
              id="name" name="name"
              maxLength="15" autoComplete="off" 
              placeholder="Enter Name" />

          </div>
          <div>
            <label htmlFor="email" >Email</label>
            <input type="text"
              id="email" name="email"
              maxLength="15" autoComplete="off" 
              placeholder="Enter Email" />

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

export default FormComponent

import React from 'react'
import { useFormik } from 'formik'

const initialValues = {
  name: 'test',
  email: ''
}

const validate = values => {
  let errors = {};
  if (!values.name) {
    errors.name = 'Required';
  }
  if (!values.email) {
    errors.email = 'Email is required';
  }
  return errors;
}

const onSubmit = values => {
  console.log(values)
}

const formik = useFormik({
  initialValues,
  validate,
  onSubmit
});

function SimpleForm1() {

  return (
    <>

      <form onSubmit={formik.handleSubmit}>
        <div>
          <label htmlFor="userid" >Name</label>
          <input type="text"
            id="name" name="name" 
            maxLength="15" autoComplete="off" {...formik.getFieldProps('name')}
            placeholder="Enter Name" />

            {formik.errors && formik.errors.name? <span>{formik.errors.name} </span> : null}
        </div>
        <div>
          <label htmlFor="email" >Email</label>
          <input type="text"
            id="email" name="email" 
            maxLength="15" autoComplete="off" {...formik.getFieldProps('email')}
            placeholder="Enter Email" />

          {formik.errors && formik.errors.email ? <span>{formik.errors.email} </span> : null}
        </div>
        <br />
        <div>
          <button type="submit"  >Submit</button>
          <button type="button" > Clear</button >
        </div>
      </form >
    </>
  )
}

export default SimpleForm1

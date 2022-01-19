import React from 'react'
import { useFormik } from 'formik'
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

const formik = useFormik({
  initialValues,
  validationSchema,
  onSubmit
});

function SimpleFormWithYup() {

  return (
    <>

      <form onSubmit={formik.handleSubmit}>
        <div>
          <label htmlFor="userid" >Name</label>
          <input type="text"
            id="name" name="name" 
            maxLength="15" autoComplete="off" onChange={formik.handleChange} value={formik.values.name}
            placeholder="Enter Name" />

            {formik.errors && formik.errors.name? <span>{formik.errors.name} </span> : null}
        </div>
        <div>
          <label htmlFor="email" >Email</label>
          <input type="text"
            id="email" name="email" 
            maxLength="15" autoComplete="off" onChange={formik.handleChange} value={formik.values.email}
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

export default SimpleFormWithYup

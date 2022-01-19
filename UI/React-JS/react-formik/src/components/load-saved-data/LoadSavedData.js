import React, {useState} from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik'
import * as Yup from 'yup'

const initialValues = {
  name: 'test',
  email: ''
}

const savedValues = {
  name: 'testSaved',
  email: 'EmailSaved'
}

const validationSchema = Yup.object({
  name: Yup.string().required("Name is required"),
  email: Yup.string().required("Email is required").email("Invalid email")
})

const onSubmit = values => {
  console.log(values)
}

function LoadSavedData() {

  const [formValues, setFormValues] = useState(null);

  return (
   
    <>
      <Formik initialValues={formValues || initialValues }
        validationSchema={validationSchema}
        onSubmit={onSubmit}
        validateOnChange={false}
        validateOnBlur={false}
        enableReinitialize>
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
          <br />
          <div>
            <button type="submit"  >Submit</button>
            <button type="button" onClick={() => setFormValues(savedValues)}> Load Saved Data</button >
          </div>
        </Form >
      </Formik>
    </>
  )
}

export default LoadSavedData

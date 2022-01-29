import React from 'react'
import { Formik, Form, Field } from 'formik'
import * as Yup from 'yup'
import FormikComponent from './FormikComponent'

const dropDownOptions = [
  {key: '', value: 'Select an option'},
  {key: 'M', value: 'Male'},
  {key: 'F', value: 'Female'}];

const radioButtonOptions = [
    {key: 'mr', value: 'Mr'},
    {key: 'mrs', value: 'Mrs'}];

const checkboxOptions = [
      {key: 'cb1', value: 'checkBox1'},
      {key: 'cb2', value: 'checkBox2'},
      {key: 'cb3', value: 'checkBox3'}];
  
const initialValues = {
  email: '',
  address: '',
  gender:'',
  salutation: '',
  checkboxOption: [],
  birthDate: null
}

const validationSchema = Yup.object({
  email: Yup.string().required("Email is required"),
  address: Yup.string().required("Address is required"),
  gender: Yup.string().required("Gender is required"),
  salutation: Yup.string().required("Salutation is required"),
  checkboxOption: Yup.array().min(1, "checkbox option is required"),
  birthDate: Yup.date().required("birthDate is required").nullable()
})

const onSubmit = values => {
console.log(values)
}

function FormikContainer() {

  return (
    <>
      <Formik initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={onSubmit}>
        {
          formik =>
            <Form>
              <FormikComponent control="input" label="Email" type="text" id="email" name="email" maxLength="15" />
              
              <FormikComponent control="textarea" label="Address" id="address" name="address" maxLength="15" />

              <FormikComponent control="dropdown" label="Gender" id="gender" name="gender" options={dropDownOptions} />

              <FormikComponent control="radioButton" label="Salutation" id="salutation" name="salutation" options={radioButtonOptions} />
            
              <FormikComponent control="checkbox" label="checkboxOption" id="checkboxOption" name="checkboxOption" options={checkboxOptions} />

              <FormikComponent control="date" label="Birth Date"  name="birthDate"  />

              <button type="submit">Submit</button>
            </Form >

        }

      </Formik>
    </>
  )
}

export default FormikContainer

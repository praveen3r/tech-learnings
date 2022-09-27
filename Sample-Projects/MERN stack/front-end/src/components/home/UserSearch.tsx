import { Form, Formik, FormikHelpers } from 'formik';
import React from 'react'
import { UserSearchType } from '../../types/FormTypes';
import InputComponent from '../formik-control/InputComponent';

const initialValues: UserSearchType = {
  name: "",
  fromDate: "",
  toDate: ""
};

function UserSearch() {

  const onSubmit = (
    values: UserSearchType,
    submitProps: FormikHelpers<UserSearchType>
  ) => {
    console.log(`coming here`);

  };

  return (
    <Formik
      initialValues={initialValues}
      onSubmit={onSubmit}
    >
      <Form>
        <div className="form-group">
          <InputComponent
            label="name"
            type="text"
            id="name"
            name="name"
            maxLength="15"
            dataType="text"
            width="20%"
          />

          <InputComponent
            label="fromDate"
            type="text"
            id="fromDate"
            name="fromDate"
            maxLength="15"
            dataType="text"
            width="20%"
          />

          <InputComponent
            label="toDate"
            type="text"
            id="toDate"
            name="toDate"
            maxLength="15"
            dataType="text"
            width="20%"
          />
        </div>
      </Form>
    </Formik>
  )
}

export default UserSearch

import React from "react";
import { Modal, Button } from "react-bootstrap";
import { FormModalType } from "../../types/ComponentType";
import { User } from "../../types/User";
import * as Yup from "yup";
import { Formik, Form, FormikHelpers } from "formik";
import InputComponent from "../formik-control/InputComponent";
import DropdownComponent from "../formik-control/DropdownComponent";
import { dropdownOptions } from "../../types/FormTypes";

const validationSchema = Yup.object({
  name: Yup.string().required("Name is required"),
  age: Yup.number()
    .positive("Age must be greater than zero")
    .typeError("Enter a valid number")
    .required("Age is required"),
  gender: Yup.string().required("Gender is required"),
});

const UserDetails = ({
  showModal,
  hideModal,
  confirmModal,
  data,
}: FormModalType<User>) => {
  const onSubmit = (values: User, submitProps: FormikHelpers<User>) => {
    confirmModal(values);
  };

  const genderOptions: dropdownOptions[] = [
    { key: "Male", value: "Male" },
    { key: "Female", value: "Female" },
  ];

  return (
    <Modal
      show={showModal}
      onHide={hideModal}
      backdrop="static"
      keyboard={false}
    >
      <Modal.Header closeButton>
        <Modal.Title>Add User</Modal.Title>
      </Modal.Header>

      <Modal.Body>
        <Formik
          initialValues={data}
          validationSchema={validationSchema}
          onSubmit={onSubmit}
        >
          {(formik) => (
            <Form>
              <div className="form-group">
                <InputComponent
                  label="Name"
                  type="text"
                  id="name"
                  name="name"
                  maxLength="15"
                  dataType="text"
                />

                <InputComponent
                  label="Age"
                  type="text"
                  id="age"
                  name="age"
                  maxLength="15"
                  dataType="number"
                  formik={formik}
                />
                <div style={{width:'40%'}}>
                  <DropdownComponent
                    label="Gender"
                    id="gender"
                    name="gender"
                    options={genderOptions}
                  />
                </div>
                {/* <InputComponent
                  label="Gender"
                  type="text"
                  id="gender"
                  name="gender"
                  maxLength="15"
                /> */}
              </div>
              <Button type="submit" variant="danger">
                Submit
              </Button>
              <Button variant="default" onClick={hideModal}>
                Cancel
              </Button>
            </Form>
          )}
        </Formik>
      </Modal.Body>
    </Modal>
  );
};

export default UserDetails;

import React from "react";
import { Modal, Button } from "react-bootstrap";
import { FormModalType } from "../../types/ComponentType";
import { User } from "../../types/User";
import * as Yup from "yup";
import { Formik, Form, FormikHelpers } from "formik";
import InputComponent from "../../components/formik-control/InputComponent";
import DropdownComponent from "../../components/formik-control/DropdownComponent";
import { dropdownOptions } from "../../types/FormTypes";
import DisplayMessage from "../../components/i18n/DisplayMessage";

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
                  label="name"
                  type="text"
                  id="name"
                  name="name"
                  maxLength="15"
                  dataType="text"
                />

                <InputComponent
                  label="age"
                  type="text"
                  id="age"
                  name="age"
                  maxLength="15"
                  dataType="number"
                  formik={formik}
                />
                <div style={{width:'40%'}}>
                  <DropdownComponent
                    label="gender"
                    id="gender"
                    name="gender"
                    options={genderOptions}
                  />
                </div>
              </div>
              <Button type="submit" variant="danger">
              <DisplayMessage id="submit"/>
              </Button>
              <Button variant="default" onClick={hideModal}>
              <DisplayMessage id="cancel"/>
              </Button>
            </Form>
          )}
        </Formik>
      </Modal.Body>
    </Modal>
  );
};

export default UserDetails;
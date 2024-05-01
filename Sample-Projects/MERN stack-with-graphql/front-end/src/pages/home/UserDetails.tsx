import { Form, Formik, FormikHelpers } from "formik";
import { isEqual } from "lodash";
import { useState } from "react";
import { Button, Modal } from "react-bootstrap";
import * as Yup from "yup";
import InfoMessage from "../../components/display/InfoMessage";
import DropdownComponent from "../../components/formik-control/DropdownComponent";
import InputComponent from "../../components/formik-control/InputComponent";
import DisplayMessage from "../../components/i18n/DisplayMessage";
import { FormModalType } from "../../types/ComponentType";
import { DropdownOptions } from "../../types/FormTypes";
import { User } from "../../types/User";

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
  const isEdit = data._id ? true : false;

  const [isInfo, setInfo] = useState(false);

  const onSubmit = (userNew: User, submitProps: FormikHelpers<User>) => {
    if (data._id && isEqual(data, userNew)) {
      setInfo(true);
    } else {
      setInfo(false);
      confirmModal(userNew);
    }
  };

  const onClickCancel = () => {
    setInfo(false);
    hideModal();
  };

  const genderOptions: DropdownOptions[] = data.genderOptions!;

  return (
    <Modal
      show={showModal}
      onHide={hideModal}
      backdrop="static"
      keyboard={false}
    >
      <Modal.Header closeButton onHide={() => setInfo(false)}>
        <Modal.Title>{isEdit ? "MODIFY User" : "Add User"} </Modal.Title>
      </Modal.Header>

      <Modal.Body>
        {isInfo && (
          <InfoMessage>
            <DisplayMessage id="noChangesToSave" />
          </InfoMessage>
        )}

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
                <div style={{ width: "40%" }}>
                  <DropdownComponent
                    label="gender"
                    id="gender"
                    name="gender"
                    options={genderOptions}
                  />
                </div>
              </div>
              <Button type="submit" variant="danger">
                <DisplayMessage id="submit" />
              </Button>
              <Button variant="default" onClick={onClickCancel}>
                <DisplayMessage id="cancel" />
              </Button>
            </Form>
          )}
        </Formik>
      </Modal.Body>
    </Modal>
  );
};

export default UserDetails;

import React, { useState } from "react";
import { Formik, Form, FormikHelpers } from "formik";
import * as Yup from "yup";
import { useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import InputComponent from "../components/formik-control/InputComponent";
import { LoginType } from "../types/FormTypes";
import { authenticate } from "../services/LoginService";
import { AxiosError } from "axios";
import Constants from "../util/Constants";
import LoadingOverlay from 'react-loading-overlay-ts';

const initialValues: LoginType = {
  username: "",
  keyword: "",
};

const validationSchema = Yup.object({
  username: Yup.string().required("Username is required"),
  keyword: Yup.string().required("Password is required"),
});

function Login() {
  const [loading, setLoading] = useState<boolean>(false);
  const [isError, setError] = useState(false);
  const navigate = useNavigate();
  //const auth = useAuth();

  const onSubmit = (values: LoginType, submitProps: FormikHelpers<LoginType>) => {
    //auth.login(values);
    setLoading(true);
    authenticate(values)
      .then((response) => {
        setLoading(false);
        navigate("/dashboard");
      })
      .catch((error: AxiosError) => {
        const status = error.response?.status;
        if (status) {
          if (!Constants.global_error_codes.includes(status)) {
            setLoading(false);
            setError(true);
            submitProps.resetForm();
          }
        }
      });
  };

  return (
    <>
     <LoadingOverlay active={loading} spinner>
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={onSubmit}
      >
        {(formik) => (
          <div className="login">
            <Form>
              {isError ? (
                <div style={{ color: "red", marginBottom: 15 }}>
                  Invalid username/password
                </div>
              ) : null}
              <div className="form-group">
                <InputComponent
                  label="Username"
                  type="text"
                  id="username"
                  name="username"
                  maxLength="15"
                  dataType="text"
                />

                <InputComponent
                  label="Password"
                  type="password"
                  id="keyword"
                  name="keyword"
                  maxLength="15"
                  dataType="password"
                />

                <Button type="submit">Submit</Button>
                <Button type="button" variant="secondary" onClick={e => formik.resetForm()}>
                  Clear
                </Button>
              </div>
            </Form>
          </div>
        )}
      </Formik>
      </LoadingOverlay>
    </>
  );
}

export default Login;

import React, { useState } from "react";
import { Formik, Form, FormikHelpers } from "formik";
import * as Yup from "yup";
import { useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import InputComponent from "../components/formik-control/InputComponent";
import { LoginType } from "../types/FormTypes";
import { AuthService } from "../services/AuthService";
import { AxiosError } from "axios";
import LoadingOverlay from "react-loading-overlay-ts";
import DisplayMessage from "../components/i18n/DisplayMessage";
//import { useTranslation } from "react-i18next";
import { ResponseData } from "../types/ResponseData";
import { useAuth } from "../components/context/Auth";
import CryptoJS from "crypto-js";

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
  const auth = useAuth();
  //const { t, i18n } = useTranslation();

  const onSubmit = (
    values: LoginType,
    submitProps: FormikHelpers<LoginType>
  ) => {
    setLoading(true);

    const hash = CryptoJS.AES.encrypt(
      values.keyword,
      "my-secret-key@123"
    ).toString();
    let valuesNew = values;
    valuesNew.keyword = hash;
    AuthService.authenticate(valuesNew)
      .then((response) => {
        if (response?.data?.token) {
          auth?.login(true, response?.data?.token);
          navigate("/dashboard");
        }
        setLoading(false);
      })
      .catch((error: AxiosError) => {
        const status = error.response?.status;
        if (status) {
          if (error.response?.status === 401) {
            const errorCode = (error.response?.data as ResponseData<string>)
              .statusCode;
            if (errorCode === "CUSTOM001") {
              setError(true);
            }
          }
        }
        setLoading(false);
        submitProps.resetForm();
      });
  };

  return (
    <>
      {/* <h1>{t('Welcome to React')}</h1> */}
      <LoadingOverlay active={loading} spinner>
        <Formik
          initialValues={initialValues}
          validationSchema={validationSchema}
          onSubmit={onSubmit}
        >
          {(formik) => (
            <div className="login">
              <Form autoComplete="false">
                {isError ? (
                  <div style={{ color: "red", marginBottom: 15 }}>
                    Invalid username/password
                  </div>
                ) : null}
                <div className="form-group">
                  <InputComponent
                    label="username"
                    type="text"
                    id="username"
                    name="username"
                    maxLength="15"
                    dataType="text"
                  />

                  <InputComponent
                    label="password"
                    type="password"
                    id="keyword"
                    name="keyword"
                    maxLength="15"
                    dataType="password"
                  />

                  <Button type="submit">
                    <DisplayMessage id="submit" />
                  </Button>
                  <Button
                    type="button"
                    variant="secondary"
                    onClick={(e) => formik.resetForm()}
                  >
                    <DisplayMessage id="clear" />
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

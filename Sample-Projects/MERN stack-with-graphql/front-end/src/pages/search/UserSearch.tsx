import { Form, Formik, FormikHelpers } from "formik";
import React, { useState } from "react";
import { UserSearchType } from "../../types/FormTypes";
import InputComponent from "../../components/formik-control/InputComponent";
import { Button } from "react-bootstrap";
import DisplayMessage from "../../components/i18n/DisplayMessage";
import DateRangePickerComponent from "../../components/formik-control/DateRangePickerComponent";

import UserSearchResults from "./UserSearchResults";
import { User } from "../../types/User";
import Constants from "../../util/Constants";
import { MessageUtils } from "../../util/MessageUtils";
import { AxiosError, AxiosRequestConfig } from "axios";
import { DateUtil } from "../../util/DateUtil";
import { UserSearchService } from "../../services/UserSearchService";
import LoadingOverlay from "react-loading-overlay-ts";

const initialValues: UserSearchType = {
  name: "",
  fromDate: null,
  toDate: null,
};

function UserSearch() {
  const [startDate, setStartDate] = useState(DateUtil.getTodayDate());
  const [endDate, setEndDate] = useState(DateUtil.getTodayDate());
  const [userData, setUserData] = useState<User[] | null>(null);
  const [displaySearchResults, setDisplaySearchResults] =
    useState<boolean>(false);
    const [overlay, setOverlay] = useState<boolean>(false);

  const onSubmit = (
    values: UserSearchType,
    submitProps: FormikHelpers<UserSearchType>
  ) => {
    /*const params: AxiosRequestConfig["params"] = {
      name: values.name,
      fromDate: DateUtil.formatDate(startDate,  Constants.date_format_ddmmyyyy),
      toDate: DateUtil.formatDate(endDate,  Constants.date_format_ddmmyyyy)
    };*/
    setOverlay(true);
    UserSearchService.getSearchData(values.name)
      .then((response) => {
        console.log(response);
        
        setUserData(response?.searchUsers);
        setDisplaySearchResults(true);
        setOverlay(false);
      })
    /*setTimeout(() => {
    UserSearchService.getSearchData(new URLSearchParams(params))
      .then((response) => {
        setUserData(response?.data?.users);
        setDisplaySearchResults(true);
        setOverlay(false);
      })
      .catch((error: AxiosError) => {
        const status = error.response?.status;
        if (status) {
          if (!Constants.global_error_codes.includes(status)) {
            MessageUtils.showError(error);
          }
          setOverlay(false);
          setDisplaySearchResults(false);
        }
      })
    }, 1500);*/
  }

  const clearForm = (formik: FormikHelpers<UserSearchType>) => {

    setDisplaySearchResults(false);
    formik.resetForm();
    setStartDate(DateUtil.getTodayDate());
  setEndDate(DateUtil.getTodayDate());
  };

  return (
    <>
    <LoadingOverlay active={overlay} spinner>
      <Formik initialValues={initialValues} onSubmit={onSubmit}>
        {(formik) => (
          <Form autoComplete="false">
            <div className="search-form">
              <div className="form-group">
                <InputComponent
                  label="name"
                  type="text"
                  id="name"
                  name="name"
                  maxLength="15"
                  dataType="text"
                />

                <DateRangePickerComponent
                  label="fromDate"
                  id="fromDate"
                  name="fromDate"
                  dateFormat="dd/MM/yyyy"
                  selected={startDate}
                  changeFn={setStartDate}
                  startDate={startDate}
                  endDate={endDate}
                  maxDate={endDate}
                />

                <DateRangePickerComponent
                  label="toDate"
                  id="toDate"
                  name="toDate"
                  dateFormat="dd/MM/yyyy"
                  selected={endDate}
                  changeFn={setEndDate}
                  startDate={startDate}
                  endDate={endDate}
                  minDate={startDate}
                />
              </div>
              <Button type="submit">
                <DisplayMessage id="submit" />
              </Button>
              <Button
                type="button"
                variant="secondary"
                onClick={() => clearForm(formik)}
              >
                <DisplayMessage id="reset" />
              </Button>
            </div>
          </Form>
        )}
      </Formik>
      </LoadingOverlay>

      <div className="search-results">
        {displaySearchResults && <UserSearchResults userData={userData} />}
      </div>
    </>
  );
}

export default UserSearch;

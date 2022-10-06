import { Form, Formik, FormikHelpers } from "formik";
import React, { useState } from "react";
import { UserSearchSubmitType, UserSearchType } from "../../types/FormTypes";
import InputComponent from "../../components/formik-control/InputComponent";
import DatePickerComponent from "../../components/formik-control/DatePickerComponent";
import { Button } from "react-bootstrap";
import DisplayMessage from "../../components/i18n/DisplayMessage";
import { format } from 'date-fns'
import DateRangePickerComponent from "../../components/formik-control/DateRangePickerComponent";

const initialValues: UserSearchType = {
  name: "",
  fromDate: null,
  toDate: null,
};

function UserSearch() {
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());

  const onSubmit = (
    values: UserSearchType,
    submitProps: FormikHelpers<UserSearchType>
  ) => {
    
    const valuesNew: UserSearchSubmitType = {
      name: values.name,
      fromDate: format(values.fromDate!, 'dd/MM/yyyy').toString(),
      toDate: format(values.toDate!, 'dd/MM/yyyy').toString()
    }
    console.log(valuesNew);
  };

  return (
    <Formik initialValues={initialValues} onSubmit={onSubmit}>
      <Form autoComplete="false">
        <div className="form-group">
          <InputComponent
            label="name"
            type="text"
            id="name"
            name="name"
            maxLength="15"
            dataType="text"
            style={{ width: "20%" }}
          />

          {/* <DatePickerComponent
            label="fromDate"
            id="fromDate"
            name="fromDate"
            dateFormat="dd/MM/yyyy"
          />

          <DatePickerComponent
            label="toDate"
            id="toDate"
            name="toDate"
            dateFormat="dd/MM/yyyy"
          /> */}

<DateRangePickerComponent
            label="fromDate"
            id="fromDate"
            name="fromDate"
            dateFormat="dd/MM/yyyy"
            selected={startDate}
            changeFn={setStartDate}
        startDate={startDate}
        endDate={endDate}
        
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
        <Button type="button" variant="secondary">
          <DisplayMessage id="clear" />
        </Button>
      </Form>
    </Formik>
  );
}

export default UserSearch;

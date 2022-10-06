import React from "react";
import { DateRangePickerType } from "../../types/FormTypes";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import DisplayMessage from "../i18n/DisplayMessage";
import { useIntl } from "react-intl";
import { rest } from "lodash";

function DateRangePickerComponent(props: DateRangePickerType) {
  const { label, name } = props;
  const intl = useIntl();
  const placeholder =
    intl.formatMessage({ id: "enter" }) +
    " " +
    intl.formatMessage({ id: label });
  return (
    <div>
      <label htmlFor={name}>
        <DisplayMessage id={label} />:
      </label>

      <DatePicker
        selected={props.selected}
        onChange={(date: Date) => props.changeFn(date)}
        startDate={props.startDate}
        endDate={props.endDate}
        minDate={props.minDate}
        maxDate={props.maxDate}
        placeholderText={placeholder}
      />
    </div>
  );
}

export default DateRangePickerComponent;

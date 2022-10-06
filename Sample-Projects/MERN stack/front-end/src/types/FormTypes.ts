import { GenericFieldHTMLAttributes } from "formik";
import React, { ChangeEvent, ChangeEventHandler } from "react";

export type InputType = GenericFieldHTMLAttributes & {
  label: string;
  type: string;
  id: string;
  name: string;
  maxLength: string;
  className?: string;
  dataType: string;
  formik?: any;
};

export type DatePickerType = GenericFieldHTMLAttributes & {
  label: string;
  id: string;
  name: string;
  className?: string;
  dateFormat?: string;
};

export type DateRangePickerType = GenericFieldHTMLAttributes & {
  label: string;
  id: string;
  className?: string;
  dateFormat?: string;
  //onChange: (ChangeEventHandler<HTMLInputElement> & ((date: Date) => void))
  changeFn: (date: Date) => void;
  startDate: Date;
  endDate: Date;
  selected: Date;
  minDate?: Date;
  maxDate?: Date
};

export type dropdownOptions = {
  key: string;
  value: string;
};

export type DropdownType = {
  label: string;
  id: string;
  name: string;
  options: dropdownOptions[];
  className?: string;
};

export type UserSearchType = {
  name: string;
  fromDate: Date | null;
  toDate: Date | null;
};

export type UserSearchSubmitType = {
  name: string;
  fromDate: string;
  toDate: string;
};

export type LoginType = {
  username: string;
  keyword: string;
};

export type SearchBarType = {
  label: string;
  placeholder: string;
  setInput?: (value: string) => void;
  searchInput?: string;
  setSearchInput?: (value: string) => void;
};

export type LocaleProvideType = {
  children: React.ReactNode;
};

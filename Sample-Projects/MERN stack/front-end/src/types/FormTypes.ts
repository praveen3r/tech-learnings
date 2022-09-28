import { GenericFieldHTMLAttributes } from "formik";
import React from "react";

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

  export type dropdownOptions = {
    key: string;
    value: string;
  }

  export type DropdownType = {
    label: string;
    id: string;
    name: string;
    options: dropdownOptions[];
    className?: string;
    
  };

  export type  UserSearchType = {
    name: string;
    fromDate: string;
    toDate: string;
  }

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
  }

  export type LocaleProvideType = {
    children: React.ReactNode,
  }
import { GenericFieldHTMLAttributes } from "formik";

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

  export type LoginType = {
    username: string;
    keyword: string;
  };
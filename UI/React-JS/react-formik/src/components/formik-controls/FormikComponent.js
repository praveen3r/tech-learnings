import React from 'react'
import { Formik, Form, Field } from 'formik'
import * as Yup from 'yup'
import TextInput from './TextInput';
import TextArea from './TextArea';
import DropDown from './DropDown';
import RadioButton from './RadioButton';
import CheckBox from './CheckBox';
import DatePicker from './DatePicker';

function FormikComponent(props) {
  const { control, ...rest } = props
  switch (control) {
    case "input":
      return <TextInput {...rest} />
    case "textarea":
      return <TextArea {...rest} />
    case "dropdown":
      return <DropDown {...rest} />
    case "radioButton":
      return <RadioButton {...rest} />
    case "checkbox":
      return <CheckBox {...rest} />
    case "date":
      return <DatePicker {...rest} />
    default:
      return null;
  }


}

export default FormikComponent

import React from "react";
import { DropdownType } from "../../types/FormTypes";
import Dropdown from "./Dropdown";


function DropdownComponent(props: DropdownType) {
  return <Dropdown {...props} className='form-control'/>; 
}

export default DropdownComponent;

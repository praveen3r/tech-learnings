import { IconButton, TextField } from "@mui/material";
import { GridSearchIcon } from "@mui/x-data-grid";
import { logRoles } from "@testing-library/react";
import React, { ChangeEvent, useState } from "react";
import { SearchBarType } from "../../types/FormTypes";

function SearchBar(props: SearchBarType) {
  const onChangeInput = (event: ChangeEvent<HTMLInputElement>) => {
    if (props.setSearchInput) {
      props.setSearchInput(event.target.value);
    }
  };

  return (
    <div>
      <TextField
        id="search-bar"
        className="text"
        label={props.label}
        variant="outlined"
        placeholder={props.placeholder}
        size="small"
        value={props.searchInput}
        onChange={onChangeInput}
      />
    </div>
  );
}

export default SearchBar;

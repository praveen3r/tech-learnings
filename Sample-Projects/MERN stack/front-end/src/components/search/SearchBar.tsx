import { IconButton, TextField } from "@mui/material";
import { GridSearchIcon } from "@mui/x-data-grid";
import React, { ChangeEvent, useState } from "react";
import { SearchBarType } from "../../types/FormTypes";

function SearchBar(props: SearchBarType) {
    const [searchInput, setSearchInput] = useState<string>('');

    const onChangeInput = (event: ChangeEvent<HTMLInputElement>) => {
        setSearchInput(event.target.value);
    }

    const onClickSearch = () => {
      if(props.setInput){
        props.setInput(searchInput);
      }
    }

  return (
    <>
      <TextField
        id="search-bar"
        className="text"
        label={props.label}
        variant="outlined"
        placeholder={props.placeholder}
        size="small"
        value={searchInput}
        onChange={onChangeInput}
        autoComplete="off"
      />
      <IconButton type="button" aria-label="search" onClick={onClickSearch}>
        <GridSearchIcon style={{ fill: "blue" }} />
      </IconButton>
    </>
  );
}

export default SearchBar;

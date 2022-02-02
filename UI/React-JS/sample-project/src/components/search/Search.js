import React, { useState } from 'react';
import DatePicker from "react-datepicker";

function Search() {

  const [startDate, setStartDate] = useState(new Date("2014/02/08"));
  const [endDate, setEndDate] = useState(new Date("2014/02/10"));

  return (
    <>
      <div><label>Field1:</label><input type="text" /></div>
      <div><label>Field2:</label><input type="text" /></div>
      <div><label>Start Date:</label>
        <DatePicker
          selected={startDate}
          onChange={(date) => setStartDate(date)}
          selectsStart
          startDate={startDate}
          endDate={endDate}
          maxDate={endDate}
        />
        </div>
      <div><label>End Date:</label>
        <DatePicker
          selected={endDate}
          onChange={(date) => setEndDate(date)}
          selectsEnd
          startDate={startDate}
          endDate={endDate}
          minDate={startDate}
        /></div>

    </>
  );
}

export default Search;

import React, {useState} from "react";
import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableFooter,
  TableHead,
  TablePagination,
  TableRow,
} from "@mui/material";
import DisplayMessage from "../../components/i18n/DisplayMessage";
import ExpandableTableRow from "../../components/table/ExpandableTableRow";

function UserSearchResults(props: any) {
  const { userData } = props;
  const [rowsPerPage, setRowsPerPage] = useState<number>(3);
  const [page, setPage] = useState<number>(0);

  const handleChangePage = (event: any, newPage: number) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event: any) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };


  return (
    <TableContainer component={Paper}>
      <Table aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell></TableCell>
            <TableCell>
              <DisplayMessage id="serialNo" />
            </TableCell>
            <TableCell align="left">
              <DisplayMessage id="name" />
            </TableCell>
            <TableCell align="left">
              <DisplayMessage id="age" />
            </TableCell>
            <TableCell align="left">
              <DisplayMessage id="gender" />
            </TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {userData?.length ? (
            userData
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map((user: any) => (
                <ExpandableTableRow
                  key={user.sNo}
                  expandComponent={
                    <TableCell colSpan={5}>{user.name}</TableCell>
                  }
                >
                  {/* <TableRow key={user.sNo}> */}
                  <TableCell component="th" scope="row">
                    {user.sNo}
                  </TableCell>
                  <TableCell align="left">{user.name}</TableCell>
                  <TableCell align="left">{user.age}</TableCell>
                  <TableCell align="left">{user.gender}</TableCell>

                  {/* </TableRow> */}
                </ExpandableTableRow>
              ))
          ) : (
            <TableRow>
              <TableCell colSpan={5}>No data to display</TableCell>
            </TableRow>
          )}
        </TableBody>
        {userData?.length ? (
          <TableFooter>
            <TableRow>
              <TablePagination
                count={userData ? userData.length : 0}
                rowsPerPage={rowsPerPage}
                page={page}
                onPageChange={handleChangePage}
                onRowsPerPageChange={handleChangeRowsPerPage}
                rowsPerPageOptions={[1, 2, 3, 4]}
                labelRowsPerPage={
                  <span>
                    <DisplayMessage id="rows" />:
                  </span>
                }
                labelDisplayedRows={({ page: number }) => {
                  return `Page: ${page}`;
                }}
                backIconButtonProps={{
                  color: "secondary",
                }}
                nextIconButtonProps={{ color: "secondary" }}
                SelectProps={{
                  inputProps: {
                    "aria-label": "page number",
                  },
                }}
                showFirstButton={true}
                showLastButton={true}
              />
            </TableRow>
          </TableFooter>
        ) : null}
      </Table>
    </TableContainer>
  );
}

export default UserSearchResults;

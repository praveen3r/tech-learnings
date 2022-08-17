import { AxiosError } from "axios";
import React, { useEffect, useState } from "react";
import { FaTrash } from "react-icons/fa";
import {
  getUsers,
  addUser,
  editUser,
  deleteUser,
} from "../../services/UserService";
import { User } from "../../types/User";
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
  TableSortLabel,
} from "@mui/material";
import { toast } from "react-toastify";
import { isEqual } from "lodash";
import { Button, Spinner } from "react-bootstrap";
import LoadingOverlay from "react-loading-overlay-ts";
import DeleteConfirmation from "../modal/DeleteConfirmation";
import UserDetails from "./UserDetails";
import SearchBar from "../search/SearchBar";
import {
  showAddSuccessMessage,
  showDeleteSuccessMessage,
  showEditSuccessMessage,
  showUnexpectedErrorMessage,
} from "../../util/MessageUtils";
import ExpandableTableRow from "../table/ExpandableTableRow";
import DisplayMessage from "../i18n/DisplayMessage";

const defaultUser: User = {
  sNo: 0,
  name: "",
  age: undefined,
  gender: "",
};

function HomeWithGrid() {
  const [userData, setUserData] = useState<User[] | null>(null);
  const [orderDirection, setOrderDirection] = useState<string>("asc");
  const [rowsPerPage, setRowsPerPage] = useState<number>(3);
  const [page, setPage] = useState<number>(0);
  const [id, setId] = useState<string>("");
  const [user, setUser] = useState<User>(defaultUser);
  const [displayConfirmationModal, setDisplayConfirmationModal] =
    useState(false);
  const [displayUserDetails, setUserDetails] = useState(false);
  const [deleteMessage, setDeleteMessage] = useState<string>("");
  const [loading, setLoading] = useState<boolean>(true);
  const [overlay, setOverlay] = useState<boolean>(false);
  const [searchInput, setSearchInput] = useState<string>("");
  

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = () => {
    setTimeout(() => {
      getUsers()
        .then((response) => {
          setUserData(response?.data?.users);
          setLoading(false);
          setOverlay(false);
        })
        .catch((error: AxiosError) => {
          setLoading(false);
          setOverlay(false);
        });
    }, 1500);
  };

  const sortArray = () => {
    const orderBy = orderDirection;
    switch (orderBy) {
      case "asc":
        return userData!.sort((a, b) => a.age! - b.age!);
      case "desc":
        return userData!.sort((a, b) => b.age! - a.age!);
      default:
        return userData!.sort((a, b) => a.age! - b.age!);
    }
  };

  const handleSortRequest = () => {
    const users = sortArray();
    setUserData(users);
    setOrderDirection(orderDirection === "asc" ? "desc" : "asc");
  };

  const handleChangePage = (event: any, newPage: number) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event: any) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  const onClickDelete = (user: User) => {
    setId(user._id!);
    setDeleteMessage(`Are you sure you want to delete ${user.name}`);
    setDisplayConfirmationModal(true);
  };

  const processDelete = (id: string) => {
    setDisplayConfirmationModal(false);
    setOverlay(true);
    setTimeout(() => {
      deleteUser(id)
        .then((response) => {
          showDeleteSuccessMessage("User");
          fetchUsers();
        })
        .catch((error: AxiosError) => {
          showUnexpectedErrorMessage();
          setOverlay(false);
        });
    }, 1500);
  };

  // Hide the modal
  const hideConfirmationModal = () => {
    setDisplayConfirmationModal(false);
  };

  const onClickAdd = () => {
    setUser(defaultUser);
    setUserDetails(true);
  };

  const onClickUser = (user: User) => {
    setUser(user);
    setUserDetails(true);
  };

  const processUser = (userNew: User) => {
    setUserDetails(false);
    if (userNew?._id) {
      processEditUser(userNew);
    } else {
      processAddUser(userNew);
    }
  };

  const processAddUser = (userNew: User) => {
    setOverlay(true);
    setTimeout(() => {
      addUser(userNew)
        .then((response) => {
          if (response?.data?.success) {
            showAddSuccessMessage("User");
            fetchUsers();
          } else {
            showUnexpectedErrorMessage();
            setOverlay(false);
          }
        })
        .catch((error: AxiosError) => {
          showUnexpectedErrorMessage();
          setOverlay(false);
        });
    }, 1500);
  };

  const processEditUser = (userNew: User) => {
    setOverlay(true);
    if (isEqual(user, userNew)) {
      toast.info(`No changes to save`, { position: toast.POSITION.TOP_RIGHT });
    } else {
      editUser(userNew, userNew._id!)
        .then((response) => {
          if (response?.data?.success) {
            showEditSuccessMessage("User");
            fetchUsers();
          } else {
            showUnexpectedErrorMessage();
          }
        })
        .catch((error: AxiosError) => {
          showUnexpectedErrorMessage();
          setOverlay(false);
        });
    }
  };

  // Hide the modal
  const hideUserDetails = () => {
    setUserDetails(false);
  };

  const setInput = (value: string) => {
    setSearchInput(value);
  };

  const filterValues = (user: User) => {
    if (!searchInput) {
      return user;
    } else {
      const newData = Object.values(user).some(
        (val) =>
          val!.toString().toLowerCase().indexOf(searchInput.toLowerCase()) >= 0
      );

      return newData;
    }
  };

  return (
    <>
      {loading ? (
        <div className="loader">
          <Spinner animation="border" aria-hidden="true" />
        </div>
      ) : (
        <>
          <LoadingOverlay active={overlay} spinner>
            {userData?.length ? (
              <div className="inline-style">
                <Button onClick={onClickAdd} className="homeBtn">
                <DisplayMessage id="add"/> <DisplayMessage id="user"/>
                </Button>
                <div className="inline-block-style right-align">
                  <SearchBar
                    label="Seach Users"
                    placeholder="Search"
                    setInput={setInput}
                  />
                </div>
              </div>
            ) : null}
            <TableContainer component={Paper}>
              <Table aria-label="simple table">
                <TableHead>
                  <TableRow>
                  <TableCell></TableCell>
                    <TableCell><DisplayMessage id="serialNo"/></TableCell>
                    <TableCell align="left"><DisplayMessage id="name"/></TableCell>
                    <TableCell align="left" onClick={handleSortRequest}>
                      <TableSortLabel
                        active={true}
                        direction={orderDirection === "asc" ? "asc" : "desc"}
                      >
                        <DisplayMessage id="age"/>
                      </TableSortLabel>
                    </TableCell>
                    <TableCell align="left"><DisplayMessage id="gender"/></TableCell>
                    <TableCell align="left"></TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {userData?.length ? (
                    userData
                      .filter(filterValues)
                      .slice(
                        page * rowsPerPage,
                        page * rowsPerPage + rowsPerPage
                      )
                      .map((user) => (
                        <ExpandableTableRow
              key={user.sNo}
              expandComponent={<TableCell colSpan={5}>{user.name}</TableCell>}
            >
                        {/* <TableRow key={user.sNo}> */}
                          <TableCell component="th" scope="row">
                            {user.sNo}
                          </TableCell>
                          <TableCell align="left">
                          <Button variant="link" onClick={() => onClickUser(user)}>
                              {user.name}
                            </Button>
                          </TableCell>
                          <TableCell align="left">{user.age}</TableCell>
                          <TableCell align="left">{user.gender}</TableCell>
                          <TableCell
                            align="left"
                            className="deleteIcon"
                            onClick={() => onClickDelete(user)}
                          >
                            <FaTrash />
                          </TableCell>
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
                        labelRowsPerPage={<span><DisplayMessage id="rows"/>:</span>}
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
            <UserDetails
              showModal={displayUserDetails}
              confirmModal={processUser}
              hideModal={hideUserDetails}
              data={user}
            />
            <DeleteConfirmation
              showModal={displayConfirmationModal}
              confirmModal={processDelete}
              hideModal={hideConfirmationModal}
              message={deleteMessage}
              id={id}
            />
          </LoadingOverlay>
        </>
      )}
    </>
  );
}

export default HomeWithGrid;

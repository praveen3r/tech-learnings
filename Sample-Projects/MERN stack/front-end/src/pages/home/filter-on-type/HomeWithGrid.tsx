import { AxiosError } from "axios";
import React, { useEffect, useState } from "react";
import { FaTrash } from "react-icons/fa";
import {
  UserService
} from "../../../services/UserService";
import { User, UserRes } from "../../../types/User";
import {
  Grid,
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
import DeleteConfirmation from "../../../components/modal/DeleteConfirmation";
import UserDetails from ".././UserDetails";
import SearchBar from "../../../components/search/SearchBarOnType";

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
  const [searchInput, setSearchInput] = useState("");

  const filterValues = (value: string) => {
    if (!value) {
      return userData;
    } else {
      const newData = userData!.filter((obj) =>
        Object.values(obj).some(
          (val) =>
            val!.toString().toLowerCase().indexOf(value.toLowerCase()) >= 0
        )
      );
      return newData;
    }
  };

  const filteredUsers = filterValues(searchInput);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = () => {
    setTimeout(() => {
      UserService.getUsers()
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
      default:
        return userData!.sort((a, b) =>
          a.age! > b.age! ? 1 : b.age! > a.age! ? -1 : 0
        );
      case "desc":
        return userData!.sort((a, b) =>
          a.age! < b.age! ? 1 : b.age! < a.age! ? -1 : 0
        );
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
      UserService.deleteUser(id)
        .then((response) => {
          toast.success(`User deleted successfully`, {
            position: toast.POSITION.TOP_RIGHT,
          });
          fetchUsers();
        })
        .catch((error: AxiosError) => {
          toast.error(`Unexpected error`, {
            position: toast.POSITION.TOP_RIGHT,
          });
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
      UserService.addUser(userNew)
        .then((response) => {
          toast.success(`User added successfully`, {
            position: toast.POSITION.TOP_RIGHT,
          });
          fetchUsers();
        })
        .catch((error: AxiosError) => {
          toast.error(`Unexpected error`, {
            position: toast.POSITION.TOP_RIGHT,
          });
          setOverlay(false);
        });
    }, 1500);
  };

  const processEditUser = (userNew: User) => {
    setOverlay(true);
    if (isEqual(user, userNew)) {
      toast.info(`No changes to save`, { position: toast.POSITION.TOP_RIGHT });
    } else {
      UserService.editUser(userNew, userNew._id!)
        .then((response) => {
          if (response?.data?.success) {
            toast.success(`User updated successfully`, {
              position: toast.POSITION.TOP_RIGHT,
            });
            fetchUsers();
          }else{
            toast.error(`Unexpected error`, {
              position: toast.POSITION.TOP_RIGHT,
            });
          }
        })
        .catch((error: AxiosError) => {
          toast.error(`Unexpected error`, {
            position: toast.POSITION.TOP_RIGHT,
          });
          setOverlay(false);
        });
    }
  };

  // Hide the modal
  const hideUserDetails = () => {
    setUserDetails(false);
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
            <Button onClick={onClickAdd} className="homeBtn">
              Add User
            </Button>
            <SearchBar
              label="Seach Users"
              placeholder="Search"
              searchInput={searchInput}
              setSearchInput={setSearchInput}
            />
            <TableContainer component={Paper}>
              <Table aria-label="simple table">
                <TableHead>
                  <TableRow>
                    <TableCell>S.No</TableCell>
                    <TableCell align="left">Name</TableCell>
                    <TableCell align="left" onClick={handleSortRequest}>
                      <TableSortLabel
                        active={true}
                        direction={orderDirection === "asc" ? "asc" : "desc"}
                      >
                        Age
                      </TableSortLabel>
                    </TableCell>
                    <TableCell align="left">Gender</TableCell>
                    <TableCell align="left"></TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {userData?.length ? (
                    filteredUsers ? (
                      filteredUsers
                        .slice(
                          page * rowsPerPage,
                          page * rowsPerPage + rowsPerPage
                        )
                        .map((user: User) => (
                          <TableRow key={user.sNo}>
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
                          </TableRow>
                        ))
                    ) : null
                  ) : (
                    <TableRow>
                      <TableCell colSpan={5}>No data to display</TableCell>
                    </TableRow>
                  )}
                </TableBody>
                <TableFooter>
                  <TableRow>
                    <TablePagination
                      count={userData ? userData.length : 0}
                      rowsPerPage={rowsPerPage}
                      page={page}
                      onPageChange={handleChangePage}
                      onRowsPerPageChange={handleChangeRowsPerPage}
                      rowsPerPageOptions={[1, 2, 3, 4]}
                      labelRowsPerPage={<span>Rows:</span>}
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

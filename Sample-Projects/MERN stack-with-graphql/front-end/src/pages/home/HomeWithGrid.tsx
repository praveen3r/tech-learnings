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
import { AxiosError } from "axios";
import { useEffect, useState } from "react";
import { Button, Spinner } from "react-bootstrap";
import { FaTrash } from "react-icons/fa";
import LoadingOverlay from "react-loading-overlay-ts";
import DisplayMessage from "../../components/i18n/DisplayMessage";
import DeleteConfirmation from "../../components/modal/DeleteConfirmation";
import SearchBar from "../../components/search/SearchBar";
import { GenderService } from "../../services/GenderService";
import { UserService } from "../../services/UserService";
import { User } from "../../types/User";
import Constants from "../../util/Constants";
import { MessageUtils } from "../../util/MessageUtils";
import UserDetails from "./UserDetails";
import { GeneralUtil } from "../../util/GeneralUtil";

let defaultUser: User = {
  sNo: 0,
  name: "",
  age: undefined,
  gender: "",
  genderOptions: [],
};

function HomeWithGrid() {
  const [userData, setUserData] = useState<User[] | null>(null);
  const [orderDirection, setOrderDirection] = useState<string>("asc");
  const [rowsPerPage, setRowsPerPage] = useState<number>(3);
  const [page, setPage] = useState<number>(1);
  const [id, setId] = useState<string>("");
  const [user, setUser] = useState<User>(defaultUser);
  const [displayConfirmationModal, setDisplayConfirmationModal] =
    useState(false);
  const [displayUserDetails, setUserDetails] = useState(false);
  const [deleteMessage, setDeleteMessage] = useState<string>("");
  const [loading, setLoading] = useState<boolean>(false);
  const [overlay, setOverlay] = useState<boolean>(false);
  const [searchInput, setSearchInput] = useState<string>("");

  useEffect(() => {
    setLoading(true);
    fetchUsers();
  }, []);

  const fetchUsers = () => {
    
    UserService.getUsers().then(response => {
      if(response && response.users){
      setUserData(response.users);
      
      }
      
    }).catch(error => {
      MessageUtils.handleError(error);
    })
    setLoading(false);
    setOverlay(false);
    
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
    console.log(event);
    
    if(newPage === 0){
      newPage = 1;
    }
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event: any) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(1);
  };

  const onClickDelete = (user: User) => {
    setId(user.id!);
    setDeleteMessage(`Are you sure you want to delete ${user.name}`);
    setDisplayConfirmationModal(true);
  };

  const processDelete = (id: string) => {
    setDisplayConfirmationModal(false);
    setOverlay(true);
    UserService.deleteUser(id)
    .then((response) => {
      MessageUtils.showDeleteSuccessMessage("User");
      fetchUsers();
    }).catch(error => {
      MessageUtils.handleError(error);    
      setOverlay(false);
    })
    
  };

  // Hide the modal
  const hideConfirmationModal = () => {
    setDisplayConfirmationModal(false);
  };

  const fetchGendersAndLoadUser = (user: User) => {
    
    GenderService.getGenders()
      .then((response) => {
        const newUser = { ...user, genderOptions: response?.data?.genders};
        setUser(newUser);
        setUserDetails(true);
      })
      .catch((error: AxiosError) => {
        MessageUtils.handleError(error);
      });
  };

  const onClickAdd = () => {
    fetchGendersAndLoadUser(defaultUser);
  };

  const onClickUser = (user: User) => {
    fetchGendersAndLoadUser(user);
  };

  const processUser = (userNew: User) => {
    setUserDetails(false);
    if (userNew?.id) {
      processEditUser(userNew);
    } else {
      processAddUser(userNew);
    }
  };

  const processAddUser = async (userNew: User) => {
    setOverlay(true);
    UserService.addUser(userNew)
    .then((response) => {
      MessageUtils.showAddSuccessMessage("User");
      fetchUsers();
    }).catch(error => {
      MessageUtils.handleError(error);
      setOverlay(false);
        
    });
    
    
  };

  const processEditUser = async (userNew: User) => {
    setOverlay(true);
    UserService.editUser(userNew, userNew.id!)
    .then((response) => {
      MessageUtils.showEditSuccessMessage("User");
      fetchUsers();
    }).catch(error => {
      MessageUtils.handleError(error);
      setOverlay(false);
        
    });
    


   
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
            <div className="inline-style">
              <Button onClick={onClickAdd} className="homeBtn">
                <DisplayMessage id="add" /> <DisplayMessage id="user" />
              </Button>
              <div className="inline-block-style right-align">
                <SearchBar
                  label="Seach Users"
                  placeholder="Search"
                  setInput={setInput}
                />
              </div>
            </div>
            <TableContainer component={Paper}>
              <Table aria-label="simple table">
                <TableHead>
                  <TableRow key={123}>
                    <TableCell>
                      <DisplayMessage id="serialNo" />
                    </TableCell>
                    <TableCell align="left">
                      <DisplayMessage id="name" />
                    </TableCell>
                    <TableCell align="left" onClick={handleSortRequest}>
                      <TableSortLabel
                        active={true}
                        direction={orderDirection === "asc" ? "asc" : "desc"}
                      >
                        <DisplayMessage id="age" />
                      </TableSortLabel>
                    </TableCell>
                    <TableCell align="left">
                      <DisplayMessage id="gender" />
                    </TableCell>
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
                        <TableRow key={user.id}>
                          <TableCell component="th" scope="row">
                            {user.sNo}
                          </TableCell>
                          <TableCell align="left">
                            <Button
                              variant="link"
                              onClick={() => onClickUser(user)}
                            >
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
                  ) : (
                    <TableRow>
                      <TableCell colSpan={5} sx={{ textAlign: "center" }}>
                        No data to display
                      </TableCell>
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

import { AxiosError } from "axios";
import React, { useEffect, useState } from "react";
import { FaTrash } from "react-icons/fa";
import {
  UserService,
} from "../../services/UserService";
import { User, UserRes } from "../../types/User";
import Button from "react-bootstrap/Button";
import DeleteConfirmation from "../../components/modal/DeleteConfirmation";
import UserDetails from "./UserDetails";
import { toast } from "react-toastify";
import { isEqual } from "lodash";
import { Spinner } from "react-bootstrap";
import LoadingOverlay from "react-loading-overlay-ts";
import DisplayMessage from "../../components/i18n/DisplayMessage";

function Home() {
  const defaultUser: User = {
    sNo: 0,
    name: "",
    age: undefined,
    gender: "",
  };
  const [loading, setLoading] = useState<boolean>(true);
  const [overlay, setOverlay] = useState<boolean>(false);
  const [userData, setUserData] = useState<UserRes | null>(null);
  const [user, setUser] = useState<User>(defaultUser);
  const [id, setId] = useState<string>("");
  const [displayConfirmationModal, setDisplayConfirmationModal] =
    useState(false);
  const [displayUserDetails, setUserDetails] = useState(false);
  const [deleteMessage, setDeleteMessage] = useState<string>("");

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = () => {
    setTimeout(() => {
      UserService.getUsers()
        .then((response) => {
          setLoading(false);
          setOverlay(false);
          setUserData(response?.data);
        })
        .catch((error: AxiosError) => {
          setLoading(false);
          setOverlay(false);
        });
    }, 1500);
  };

  const onClickAdd = () => {
    setUser(defaultUser);
    setUserDetails(true);
  };

  const onClickDelete = (user: User) => {
    setId(user._id!);
    setDeleteMessage(`Are you sure you want to delete ${user.name}`);
    setDisplayConfirmationModal(true);
  };

  const onClickUser = (user: User) => {
    setUser(user);
    setUserDetails(true);
  };

  const submitDelete = (id: string) => {
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
          toast.success(`User updated successfully`, {
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
    }
  };

  // Hide the modal
  const hideConfirmationModal = () => {
    setDisplayConfirmationModal(false);
  };

  // Hide the modal
  const hideUserDetails = () => {
    setUserDetails(false);
  };

  return (
    <>
      {loading ? (
        // <ClipLoader loading={loading} cssOverride={{flex: 1, alignSelf:'center' , justifyContent: 'center', alignItems:'center'}}/>
        <div className="loader">
          <Spinner animation="border" aria-hidden="true" />
        </div>
      ) : (
        <>
          <LoadingOverlay active={overlay} spinner>
            <Button onClick={onClickAdd} className="homeBtn">
            <DisplayMessage id="add"/> <DisplayMessage id="user"/>
            </Button>
            <table>
              <thead>
                <tr>
                  <th><DisplayMessage id="serialNo"/></th>
                  <th><DisplayMessage id="name"/></th>
                  <th><DisplayMessage id="age"/></th>
                  <th><DisplayMessage id="gender"/></th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                {userData?.users.length ? (
                  userData?.users.map((user) => (
                    <tr key={user._id}>
                      <td> {user.sNo}</td>
                      <td>
                      <Button variant="link" onClick={() => onClickUser(user)}>
                              {user.name}
                            </Button>
                      </td>
                      <td> {user.age}</td>
                      <td> {user.gender}</td>
                      <td
                        onClick={() => onClickDelete(user)}
                        className="deleteIcon"
                      >
                        <FaTrash />
                      </td>
                    </tr>
                  ))
                ) : (
                  <tr>
                    <td colSpan={5}>No data to display</td>
                  </tr>
                )}
              </tbody>
            </table>
            <UserDetails
              showModal={displayUserDetails}
              confirmModal={processUser}
              hideModal={hideUserDetails}
              data={user}
            />
            <DeleteConfirmation
              showModal={displayConfirmationModal}
              confirmModal={submitDelete}
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

export default Home;

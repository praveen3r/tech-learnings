import { toast } from "react-toastify";

const showAddSuccessMessage = (entity: string) => {
  toast.success(`${entity} added successfully`, {
    position: toast.POSITION.TOP_RIGHT,
  });
};

const showEditSuccessMessage = (entity: string) => {
  toast.success(`${entity} updated successfully`, {
    position: toast.POSITION.TOP_RIGHT,
  });
};

const showDeleteSuccessMessage = (entity: string) => {
  toast.success(`${entity} deleted successfully`, {
    position: toast.POSITION.TOP_RIGHT,
  });
};

const showUnexpectedErrorMessage = () => {
  toast.error(`Unexpected error`, {
    position: toast.POSITION.TOP_RIGHT,
  });
};

const showErrorMessage = (message: string) => {
  toast.error(message, {
    position: toast.POSITION.TOP_RIGHT,
  });
};

export { showAddSuccessMessage, showEditSuccessMessage, showDeleteSuccessMessage, showUnexpectedErrorMessage, showErrorMessage };

import { AxiosError } from "axios";
import { toast } from "react-toastify";
import { ResponseData } from "../types/ResponseData";
import { GeneralUtil } from "./GeneralUtil";
import Constants from "./Constants";

export class MessageUtils {

  static showAddSuccessMessage = (entity: string) => {
    toast.success(`${entity} added successfully`, {
      position: toast.POSITION.TOP_RIGHT,
    });
  };

  static showEditSuccessMessage = (entity: string) => {
    toast.success(`${entity} updated successfully`, {
      position: toast.POSITION.TOP_RIGHT,
    });
  };

  static showDeleteSuccessMessage = (entity: string) => {
    toast.success(`${entity} deleted successfully`, {
      position: toast.POSITION.TOP_RIGHT,
    });
  };

  static showUnexpectedErrorMessage = () => {
    toast.error(`Unexpected error`, {
      position: toast.POSITION.TOP_RIGHT,
    });
  };

  static showErrorMessage = (message: string) => {
    toast.error(message, {
      position: toast.POSITION.TOP_RIGHT,
    });
  };

  static showError = (error: AxiosError) => {
    const message = (error.response?.data as ResponseData<string>).statusMsg;
    toast.error(message, {
      position: toast.POSITION.TOP_RIGHT,
    });
  };

  static handleError = (error: any) => {
    const errorObj = GeneralUtil.getErrorValues(error);
    if (!Constants.global_error_codes.includes(errorObj.statusCode!)) {
      MessageUtils.showErrorMessage(errorObj.errorMessage!);
    }
  };
}

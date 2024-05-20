import {Error} from './../types/Error';

export class GeneralUtil {

static getErrorValues = (error: any) => {
    const errorObj = new Error();
    let statusCode = 0;
    let errorMessage = "";
    if (error.networkError) {
      const response = error.networkError.response;
      if(response){
        errorMessage = response.statusText;
        statusCode = response.status;
      }
    } else {
      error.forEach((error1: { message: any; extensions: { statusCode: any; }; }) => {
        errorMessage = error1.message;
        statusCode = error1.extensions.statusCode;
      });
    }
    errorObj.statusCode = statusCode;
    errorObj.errorMessage = errorMessage;
    return errorObj;
  };
}
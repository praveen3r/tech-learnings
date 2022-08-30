import {
  AxiosError,
  AxiosInstance,
  AxiosRequestConfig,
  AxiosResponse,
} from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { ErrorResponse } from "../types/ComponentType";

const onRequest = (config: AxiosRequestConfig): AxiosRequestConfig => {
  //console.info(`[request] [${JSON.stringify(config)}]`);
  const token = localStorage.getItem("token");
  if (token) {
    config.headers = {
      Authorization: "Bearer "+token
    };
  }
  return config;
};

const onResponseError = (error: AxiosError): Promise<AxiosError> => {
  //console.error(`[response error] [${JSON.stringify(error)}]`);
  if (error.response?.status === 401) {
    toast.error((error.response?.data as ErrorResponse).message, {
      position: toast.POSITION.TOP_RIGHT,
    });
  }
  return Promise.reject(error);
};

/* const onRequestError = (error: AxiosError): Promise<AxiosError> => {
   console.error(`[request error] [${JSON.stringify(error)}]`);
   return Promise.reject(error);
}

const onResponse = (response: AxiosResponse): AxiosResponse => {
   console.info(`[response] [${JSON.stringify(response)}]`);
   return response;
}

const onResponseError = (error: AxiosError): Promise<AxiosError> => {
   console.error(`[response error] [${JSON.stringify(error)}]`);
   return Promise.reject(error);
} */

const onResponse = (response: AxiosResponse): AxiosResponse => {
  return response;
};

export function interceptor(axiosInstance: AxiosInstance): AxiosInstance {
  //axiosInstance.interceptors.request.use(onRequest, onRequestError);
  //axiosInstance.interceptors.response.use(onResponse, onResponseError);
  axiosInstance.interceptors.request.use(onRequest);
  axiosInstance.interceptors.response.use(onResponse, onResponseError);
  return axiosInstance;
}

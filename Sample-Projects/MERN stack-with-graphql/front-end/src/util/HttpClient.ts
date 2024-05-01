import axios from 'axios'
import { interceptor } from './Interceptor';

const httpClient = axios.create({
    baseURL: process.env.REACT_APP_API_HOST,
    timeout: 5000,
    headers: {
        "Accept": "application/json",
        "Content-type": "application/json"
      }
    });

    interceptor(httpClient);

    export default httpClient;

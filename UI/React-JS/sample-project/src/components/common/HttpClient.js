import axios from 'axios'
import { interceptor } from './Interceptor';

const httpClient = axios.create({
    baseURL: process.env.REACT_APP_API_URL,
    });

    interceptor(httpClient);

    export default httpClient;

import axios from 'axios'
import { interceptor } from './Interceptor';

const httpClient = axios.create({
    baseURL: 'http://localhost:5000/api',
    timeout: 5000,
    headers: {
        "Accept": "application/json",
        "Content-type": "application/json"
      }
    });

    interceptor(httpClient);

    export default httpClient;

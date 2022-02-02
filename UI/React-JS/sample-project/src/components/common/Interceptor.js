
export function interceptor(axiosInstance){
    axiosInstance.interceptors.request.use(
        (req) => {
            req.headers['Authorization'] = '123'
           return req;
        },
        (err) => {
           return Promise.reject(err);
        }
     );
     
     axiosInstance.interceptors.response.use(
        (res) => {
           if (res.status === 200) {
              console.log('Success');
           }
           return res;
        },
        (err) => {
           return Promise.reject(err);
        }
     );
}
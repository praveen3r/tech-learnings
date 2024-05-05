export interface ResponseData<T> {

    statusCode:string | null;
    statusMsg:string | null;
    success:boolean;
    data: T | null;
    
}
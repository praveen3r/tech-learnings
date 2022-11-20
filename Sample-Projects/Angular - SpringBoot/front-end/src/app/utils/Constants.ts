import { StatusCodes } from 'http-status-codes';

export class Constants {
  public static HTTP_POST_SUCCESS_CODE = StatusCodes.CREATED;
  public static HTTP_PUT_SUCCESS_CODE = StatusCodes.NO_CONTENT;
  public static HTTP_DELETE_SUCCESS_CODE = StatusCodes.NO_CONTENT;

  public static PAGE_SIZE = 2;
  public static PAGE_SIZE_OPTIONS = [2, 5, 10, 25, 100];

  public static DATEFORMAT_DDMMYYYY = 'dd/MM/yyyy';
}

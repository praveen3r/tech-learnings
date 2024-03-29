import CryptoJS from 'crypto-js';
import * as _ from 'lodash';

export class GeneralUtils {
  public static removeLastChar = (value: string) => {
    return value.slice(0, -1);
  };

  public static isEmpty = (value: string) => {
    return value == '';
  };

  public static isNotEmpty = (value: string) => {
    if (value) {
      return true;
    }
    return false;
  };

  public static isValidObj = (value: Object) => {
    if (value) {
      return true;
    }
    return false;
  };

  public static isNotEmptyObj = (value: Object) => {
    if (GeneralUtils.isValidObj(value)) {
      if (Object.keys(value).length !== 0) {
        return true;
      }
    }
    return false;
  };

  public static isEqual = (obj1: Object, obj2: Object) => {
    return _.isEqual(obj1, obj2);
  };

  //allow only number
  public static removeChar(value: string): string {
    let transformedInput: string;
    if (value) {
      transformedInput = value.replace(/[^0-9]/g, '');
      transformedInput = transformedInput.replace(/\s+/g, '');
    }
    return transformedInput;
  }

  //allow only apha numeric
  public static removeSpecialChar(value: string): string {
    let transformedInput: string;
    if (value) {
      transformedInput = value.replace(/[^a-z0-9]/g, '');
      transformedInput = transformedInput.replace(/\s+/g, '');
    }
    return transformedInput;
  }

  //allow only apha numeric
  public static allowDecimal(value: string): string {
    let transformedInput: string;
    if (value) {
      transformedInput = value.replace(/[^0-9.]/g, '');
      transformedInput = transformedInput.replace(/\s+/g, '');
    }
    return transformedInput;
  }

  public static getEncryptedData(text: string, key: string): string {
    return CryptoJS.AES.encrypt(text, CryptoJS.enc.Base64.parse(key), {
      mode: CryptoJS.mode.ECB,
      padding: CryptoJS.pad.Pkcs7,
    }).toString();
  }
}

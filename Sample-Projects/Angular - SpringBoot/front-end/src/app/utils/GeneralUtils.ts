import * as _ from 'lodash';

export class GeneralUtils {
  public static removeLastChar = (value: string) => {
    return value.slice(0, -1);
  };

  public static isEmpty = (value: string) => {
    return value == '';
  };

  public static isEqual = (obj1: Object, obj2: Object) => {
    return _.isEqual(obj1, obj2);
  };
}

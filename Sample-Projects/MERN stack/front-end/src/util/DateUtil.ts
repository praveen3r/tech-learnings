import { format } from "date-fns";

export class DateUtil {

    static getTodayDate = () => {
        return new Date();
      };

    static formatDate = (date: Date | null, dateFormat: string): string => {
        
        return format(
            date ? date : DateUtil.getTodayDate(),
            dateFormat
          ).toString();
    }
}
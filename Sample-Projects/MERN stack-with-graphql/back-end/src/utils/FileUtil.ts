import { Readable, Stream } from "stream";
import XLSX, { WritingOptions } from "xlsx";
import { JSONType } from "../types/JSONType";

export class FileUtil {
  static createXLSXFile(data: JSONType[] | Object[], heading: string[][]): Stream {
    const workbook = XLSX.utils.book_new();

    const ws = XLSX.utils.json_to_sheet(data, {skipHeader: true});
    XLSX.utils.book_append_sheet(workbook, ws, "sheet1");

    XLSX.utils.sheet_add_aoa(ws, heading);

    const wbOpts: WritingOptions = { bookType: "xlsx", type: "buffer" };
    const wbOut = XLSX.write(workbook, wbOpts);

    const stream = FileUtil.bufferToStream(wbOut); // convert buffer to stream
    return stream;
  }

  static bufferToStream(buffer: any) {
    let stream = new Readable();
    stream.push(buffer);
    stream.push(null);

    return stream;
  }
}

import { AxiosError } from "axios";
import React from "react";
import { Button } from "react-bootstrap";
import DisplayMessage from "../../components/i18n/DisplayMessage";
import { UserService } from "../../services/UserService";

function Download() {
  const download = () => {
    UserService.download()
      .then((response) => {
        const fileName:string = "Download.xlsx";
        let downloadLink = document.createElement("a");
        const file = new Blob([response.data], { type: "arraybuffer" });
        const fileURL = URL.createObjectURL(file);
        downloadLink.href = fileURL;
        downloadLink.download = fileName;
        document.body.appendChild(downloadLink);
        downloadLink.click();
        document.body.removeChild(downloadLink);
      })
      .catch((error: AxiosError) => {
      });
  };
  return (
    <Button type="submit" onClick={download}>
      <DisplayMessage id="download" />
    </Button>
  );
}

export default Download;

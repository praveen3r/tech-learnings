import { Alert } from "react-native";

export class MessageUtils {
  static showErrorMessage = (message: string) => {
    Alert.alert("Error", message, [{ text: "OK" }], {
      cancelable: true,
    });
  };

  static showErrorObjMessage = (message: Object) => {
    let errorMsg = "";
    Object.values(message).forEach((value) => {
      errorMsg = errorMsg + value + "\n\n";
    });
    MessageUtils.showErrorMessage(errorMsg);
  };
}

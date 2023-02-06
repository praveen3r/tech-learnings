import React from "react";
import { Alert, Button } from "react-native";

function AlertComp() {
  const handleOnPress = () => {
    Alert.alert("Alert Title1", "My Alert Msg", [
      {
        text: "Cancel",
        onPress: () => console.log("Cancel Pressed"),
        style: "cancel",
      },
      { text: "OK", onPress: () => console.log("OK Pressed") },
    ]);
  };

  return <Button title="Submit" onPress={handleOnPress} />;
}

export default AlertComp;

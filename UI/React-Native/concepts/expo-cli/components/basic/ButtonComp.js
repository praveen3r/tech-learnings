import React from "react";
import { Button } from "react-native";

function ButtonComp() {
  const handleOnPress = () => {
    console.log(`coming here`);
  };

  return <Button title="Submit" onPress={handleOnPress} />;
}

export default ButtonComp;

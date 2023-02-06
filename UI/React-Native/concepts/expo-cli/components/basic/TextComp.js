import React from "react";
import { Text } from "react-native";

function TextComp() {
  const handleOnPress = () => {
    console.log("coming here");
  };

  return (
    <Text numberOfLines={1} onPress={handleOnPress}>
      Open up App.js to start working on your app. This is a really long test
      and let's see how it works
    </Text>
  );
}

export default TextComp;

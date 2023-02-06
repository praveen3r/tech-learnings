import React, { useState } from "react";
import { Button, Text } from "react-native";

function StateComp() {
  const [name, setName] = useState("TestName");

  const handlePress = () => {
    setName("UpdatedName");
  };
  return (
    <>
      <Text>{name}</Text>

      <Button title="Update" onPress={handlePress} />
    </>
  );
}

export default StateComp;

import React, { useState } from "react";
import { StyleSheet, Text, TextInput } from "react-native";

function TextInputComp() {
  const [name, setName] = useState("TestName");

  return (
    <>
      <Text>Enter name:</Text>
      <TextInput
        style={styles.input}
        placeholder="Enter name"
        value={name}
        onChangeText={(val) => setName(val)}
      />

      <Text>Enter age:</Text>
      <TextInput
        style={styles.input}
        placeholder="Enter age"
        keyboardType="numeric"
      />
    </>
  );
}

const styles = StyleSheet.create({
  input: {
    borderWidth: 1,
    borderColor: "black",
    padding: 8,
    width: 200,
    margin: 10,
  },
});

export default TextInputComp;

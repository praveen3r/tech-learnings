import React from "react";
import { StyleSheet, TextInput } from "react-native";

function InputComponent(props: any) {
  const { dataType } = props;
  switch (dataType) {
    case "keyword":
      return <TextInput {...props} style={styles.input} />;
    case "number":
      return <TextInput {...props} style={styles.input} />;

    default:
      return <TextInput {...props} style={styles.input} />;
  }
}

const styles = StyleSheet.create({
  input: {
    width: 300,
    borderWidth: 1,
    borderColor: "#555",
    borderRadius: 10,
    backgroundColor: "#ffffff",
    textAlign: "center",
    fontSize: 20,
    marginBottom: 25,
    height: 40,
  },
});

export default InputComponent;

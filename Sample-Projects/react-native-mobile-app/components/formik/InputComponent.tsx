import React from "react";
import { StyleSheet } from "react-native";
import InputField from "./InputField";

function InputComponent(props: any) {
  const { dataType } = props;
  switch (dataType) {
    case "keyword":
      return <InputField {...props} style={styles.input} secureTextEntry />;
    case "number":
      return (
        <InputField {...props} style={styles.input} keyboardType="numeric" />
      );

    default:
      return <InputField {...props} style={styles.input} />;
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

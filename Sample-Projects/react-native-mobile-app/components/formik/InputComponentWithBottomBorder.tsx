import React from "react";
import { StyleSheet } from "react-native";
import InputField from "./InputField";

function InputComponentWithBottomBorder(props: any) {
  const { dataType } = props;
  switch (dataType) {
    case "keyword":
      return (
        <InputField {...props} style={styles.input} secureTextEntry={true} />
      );
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
    borderBottomWidth: 1,
    borderColor: "#555",
    textAlign: "left",
    fontSize: 20,
    paddingLeft: 10,
    paddingBottom: 20,
    marginBottom: 25,
    height: 60,
  },
});

export default InputComponentWithBottomBorder;

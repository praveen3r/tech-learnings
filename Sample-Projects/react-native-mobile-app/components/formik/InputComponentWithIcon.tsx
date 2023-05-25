import React from "react";
import { StyleSheet } from "react-native";
import InputFieldWithoutError from "./InputFieldWithoutError";

function InputComponentWithIcon(props: any) {
  const { dataType } = props;
  switch (dataType) {
    case "keyword":
      return (
        <InputFieldWithoutError
          {...props}
          style={styles.input}
          secureTextEntry
        />
      );
    case "number":
      return (
        <InputFieldWithoutError
          {...props}
          style={styles.input}
          keyboardType="numeric"
        />
      );

    default:
      return <InputFieldWithoutError {...props} style={styles.input} />;
  }
}

const styles = StyleSheet.create({
  input: {
    flex: 1,
    paddingLeft: 20,
    fontSize: 20,
    textAlign: "left",
  },
});

export default InputComponentWithIcon;

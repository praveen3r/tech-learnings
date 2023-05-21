import React from "react";
import { StyleSheet, TextInput } from "react-native";

function InputComponentWithIcon(props: any) {
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
    flex: 1,
    paddingLeft: 20,
    fontSize: 20,
    textAlign: "left",
  },
});

export default InputComponentWithIcon;

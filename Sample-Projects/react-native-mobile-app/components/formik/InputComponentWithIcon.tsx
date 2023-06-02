import { Ionicons } from "@expo/vector-icons/";
import React, { useState } from "react";
import { StyleSheet } from "react-native";
import InputFieldWithoutError from "./InputFieldWithoutError";

function InputComponentWithIcon(props: any) {
  const { dataType } = props;
  const [secure, setSecure] = useState<boolean>(true);
  switch (dataType) {
    case "keyword":
      return (
        <>
          <InputFieldWithoutError
            {...props}
            style={styles.input}
            secureTextEntry={secure}
          />
          <Ionicons
            name="eye"
            size={28}
            style={styles.icon}
            onPress={() => setSecure(!secure)}
          />
        </>
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
  icon: {
    paddingTop: 10,
    paddingRight: 10,
  },
});

export default InputComponentWithIcon;

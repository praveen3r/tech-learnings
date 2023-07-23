import { FontAwesome, Ionicons } from "@expo/vector-icons/";
import React, { useState } from "react";
import { StyleSheet, View } from "react-native";
import InputFieldWithoutError from "./InputFieldWithoutError";

function InputComponentWithIcon(props: any) {
  const { dataType, iconType } = props;
  const [secure, setSecure] = useState<boolean>(true);
  switch (dataType) {
    case "keyword":
      return (
        <View style={styles.container}>
          {props.isLeftIcon && (
            <FontAwesome name={"lock"} size={28} style={styles.icon} />
          )}
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
        </View>
      );
    case "number":
      return (
        <InputFieldWithoutError
          {...props}
          style={styles.input}
          keyboardType="numeric"
        />
      );
    case "text":
      switch (iconType) {
        case "user":
          return (
            <View style={styles.container}>
              <FontAwesome name={"user"} size={28} style={styles.icon} />
              <InputFieldWithoutError {...props} style={styles.input} />
            </View>
          );
        default:
          return (
            <View style={styles.container}>
              <FontAwesome name={"user"} size={28} style={styles.icon} />
              <InputFieldWithoutError {...props} style={styles.input} />
            </View>
          );
      }
    default:
      return <InputFieldWithoutError {...props} style={styles.input} />;
  }
}

const styles = StyleSheet.create({
  container: {
    flexDirection: "row",
    width: 300,
    borderWidth: 1,
    borderColor: "#555",
    borderRadius: 10,
    backgroundColor: "#ffffff",
    marginBottom: 25,
    height: 50,
  },
  input: {
    flex: 1,
    paddingLeft: 20,
    fontSize: 20,
    textAlign: "left",
  },
  icon: {
    paddingTop: 10,
    paddingLeft: 10,
    paddingRight: 10,
  },
});

export default InputComponentWithIcon;

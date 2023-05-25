import React from "react";
import { StyleSheet, Text } from "react-native";

const TextError: React.ComponentType<{}> = (props: any) => {
  return (
    <>
      <Text style={styles.error}>{props.children}</Text>
    </>
  );
};

const styles = StyleSheet.create({
  error: {
    color: "#ff0000",
    marginBottom: 25,
  },
});

export default TextError;

import React from "react";
import { Pressable, StyleSheet, Text } from "react-native";
import { CustomButtonType } from "../../types/ComponentType";

const CustomButtonModal = (props: CustomButtonType) => {
  return (
    <Pressable
      onPress={props.onPressFunction}
      hitSlop={{ top: 10, bottom: 10, right: 10, left: 10 }}
      android_ripple={{ color: "#00000050" }}
      style={[styles.button, { ...props.style }]}
    >
      <Text style={styles.text}>{props.title}</Text>
    </Pressable>
  );
};

const styles = StyleSheet.create({
  text: {
    color: "white",
    fontSize: 16,
    margin: 10,
    textAlign: "center",
  },
  button: {
    backgroundColor: "blue",
    alignItems: "center",
    borderRadius: 5,
    margin: 10,
  },
});

export default CustomButtonModal;

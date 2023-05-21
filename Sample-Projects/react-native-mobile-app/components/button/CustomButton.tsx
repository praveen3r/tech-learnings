import React from "react";
import { Pressable, StyleSheet, Text } from "react-native";
import { CustomButtonType } from "../../types/ComponentType";

const CustomButton = (props: CustomButtonType) => {
  return (
    <Pressable
      onPress={props.onPressFunction}
      hitSlop={{ top: 10, bottom: 10, right: 10, left: 10 }}
      android_ripple={{ color: "#00000050" }}
      style={({ pressed }) => [
        { backgroundColor: pressed ? "#dddddd" : "#1eb900" },
        styles.button,
        { ...props.style },
      ]}
    >
      <Text style={styles.text}>{props.title}</Text>
    </Pressable>
  );
};

const styles = StyleSheet.create({
  text: {
    color: "#ffffff",
    fontSize: 20,
    margin: 10,
    textAlign: "center",
  },
  button: {
    width: 150,
    height: 50,
    alignItems: "center",
    borderRadius: 5,
    margin: 10,
  },
});

export default CustomButton;

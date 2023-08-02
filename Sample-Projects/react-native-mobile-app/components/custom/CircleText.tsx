import React from "react";
import { StyleSheet, Text, View } from "react-native";
import Svg, { Circle } from "react-native-svg";
import GlobalStyles from "../style/GlobalStyles";

const CircleText = ({ text, radius }: any) => {
  return (
    <View style={styles.container}>
      <Svg height={radius * 2} width={radius * 2}>
        <Circle
          cx={radius}
          cy={radius}
          r={radius}
          stroke="black"
          strokeWidth="2"
          fill="transparent"
        />
      </Svg>
      <Text style={[styles.text, GlobalStyles.textColor]}>{text}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    alignItems: "center",
    justifyContent: "center",
  },
  text: {
    position: "absolute",
    textAlign: "center",
    textAlignVertical: "center",
  },
});

export default CircleText;

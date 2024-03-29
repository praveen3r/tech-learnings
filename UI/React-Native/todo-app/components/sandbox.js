import React from "react";
import { StyleSheet, Text, View } from "react-native";

function Sandbox() {
  return (
    <View style={styles.container}>
      <Text style={styles.box1}>box 1</Text>
      <Text style={styles.box2}>box 2</Text>
      <Text style={styles.box3}>box 3</Text>
      <Text style={styles.box4}>box 4</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    //flex: 1,
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "flex-end",
    paddingTop: 40,
    backgroundColor: "#ddd",
  },
  box1: {
    flex: 2,
    backgroundColor: "violet",
    padding: 10
  },
  box2: {
    flex: 1,
    backgroundColor: "gold",
    padding: 20
  },
  box3: {
    flex: 1,
    backgroundColor: "coral",
    padding: 30
  },
  box4: {
    flex: 1,
    backgroundColor: "skyblue",
    padding: 40
  },

});

export default Sandbox;

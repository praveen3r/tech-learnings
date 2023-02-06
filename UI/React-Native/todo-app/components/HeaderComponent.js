import React from "react";
import { StyleSheet, Text, View } from "react-native";

function HeaderComponent() {
  return (
    <View style={styles.header}>
      <Text style={styles.text}>My Todos</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  header: {
    height: 80,
    paddingTop: 40,
    backgroundColor: "coral",
  },
  text: {
    textAlign: "center",
    color: "#fff",
    fontSize: 18,
    fontWeight: "bold",
  },
});

export default HeaderComponent;

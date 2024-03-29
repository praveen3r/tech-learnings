import React from "react";
import { View, StyleSheet, Text } from "react-native";
import GlobalStyle from "../utils/GlobalStyle";

function GoogleMap({ route }) {
  const { city, lat, lng } = route.params;

  return (
    <View style={styles.body}>
      <Text style={styles.text}>{city}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  body: {
    flex: 1,
    alignItems: "center",
  },
  text: {
    fontSize: 40,
    margin: 10,
  },
  map: {
    width: "100%",
    height: "100%",
  },
});

export default GoogleMap;

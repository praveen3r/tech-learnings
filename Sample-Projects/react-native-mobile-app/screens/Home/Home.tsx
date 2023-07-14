import React from "react";
import { StyleSheet, Text, View } from "react-native";
const Home = () => {
  return (
    <View style={styles.body}>
      <Text>Welcome User</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  body: {
    flex: 1,
    marginTop: 60,
  },
});

export default Home;

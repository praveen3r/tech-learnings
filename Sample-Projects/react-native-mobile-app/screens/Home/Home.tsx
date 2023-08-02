import React from "react";
import { StyleSheet, Text, View } from "react-native";
import GlobalStyles from "../../components/style/GlobalStyles";
const Home = () => {
  return (
    <View style={GlobalStyles.background}>
      <Text>Welcome User</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  body: {
    backgroundColor: "blue",
  },
});

export default Home;

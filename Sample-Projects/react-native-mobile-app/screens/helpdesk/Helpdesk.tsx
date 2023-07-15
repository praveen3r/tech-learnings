import { Feather, MaterialIcons } from "@expo/vector-icons";
import React from "react";
import { StyleSheet, Text, View } from "react-native";
import CardWithChild from "../../components/card/CardWithChild";

const Helpdesk = () => {
  return (
    <View style={styles.container}>
      <CardWithChild title="Call/Email Support">
        <View style={styles.cardBody}>
          <View style={styles.cardText}>
            <Feather name="phone" size={24} color="black" />
            <Text style={styles.text}>080-11111111</Text>
          </View>
          <View style={styles.cardText}>
            <MaterialIcons name="email" size={24} color="black" />
            <Text style={styles.text}>Test@test.com</Text>
          </View>
        </View>
      </CardWithChild>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    marginTop: 60,
    flex: 1,
    padding: 16,
    backgroundColor: "#f2f2f2",
  },
  text: {
    fontSize: 16,
    marginLeft: 20,
  },
  cardBody: {
    alignItems: "flex-start",
  },
  cardText: {
    flexDirection: "row",
    marginTop: 20,
  },
});

export default Helpdesk;

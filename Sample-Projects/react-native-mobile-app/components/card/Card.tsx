import React from "react";
import { StyleSheet, Text, View } from "react-native";
import { CustomCardType } from "../../types/ComponentType";

const Card = (props: CustomCardType) => {
  return (
    <View style={styles.card}>
      <Text style={styles.title}>{props.title}</Text>
      <Text style={styles.text}>{props.data}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  card: {
    backgroundColor: "#fff",
    borderRadius: 8,
    padding: 16,
    marginBottom: 16,
    shadowColor: "#000",
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 2,
  },
  title: {
    fontSize: 18,
    fontWeight: "bold",
    marginBottom: 8,
  },
  text: {
    fontSize: 16,
    color: "#888",
  },
});
export default Card;

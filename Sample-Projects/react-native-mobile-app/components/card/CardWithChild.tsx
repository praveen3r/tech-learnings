import React from "react";
import { StyleSheet, Text, View } from "react-native";
import { CustomCardWithChildrenType } from "../../types/ComponentType";

const CardWithChild = (props: CustomCardWithChildrenType) => {
  return (
    <View style={styles.card}>
      {props.title && <Text style={styles.title}>{props.title}</Text>}
      {props.children}
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
    marginRight: 20,
  },
  title: {
    fontSize: 18,
    fontWeight: "bold",
    marginBottom: 8,
    alignSelf: "center",
  },
});
export default CardWithChild;

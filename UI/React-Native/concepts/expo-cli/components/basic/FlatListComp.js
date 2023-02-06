import React from "react";
import { FlatList, StyleSheet, Text, View } from "react-native";

const persons = [
  {
    name: "Person1",
    age: 21,
    key: 21,
  },
  {
    name: "Person2",
    age: 22,
    key: 22,
  },
  {
    name: "Person3",
    age: 23,
    key: 23,
  },
  {
    name: "Person4",
    age: 24,
    key: 24,
  },
  {
    name: "Person5",
    age: 25,
    key: 25,
  },
  {
    name: "Person6",
    age: 26,
    key: 26,
  },
  {
    name: "Person7",
    age: 27,
    key: 27,
  },
  {
    name: "Person8",
    age: 28,
    key: 28,
  },
];

function FlatListComp() {
  return (
    <FlatList
      keyExtractor={(item) => item.age}
      data={persons}
      renderItem={({ item }) => (
        <View style={styles.list}>
          <Text>{item.name}</Text>
          <Text>{item.age}</Text>
        </View>
      )}
    />
  );
}

const styles = StyleSheet.create({
  list: {
    fontSize: 24,
    backgroundColor: "pink",
    margin: 30,
  },
});

export default FlatListComp;

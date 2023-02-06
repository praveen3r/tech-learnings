import React from "react";
import { ScrollView, StyleSheet, Text, View } from "react-native";

const persons = [
  {
    name: "Person1",
    age: 21,
  },
  {
    name: "Person2",
    age: 22,
  },
  {
    name: "Person3",
    age: 23,
  },
  {
    name: "Person4",
    age: 24,
  },
  {
    name: "Person5",
    age: 25,
  },
  {
    name: "Person6",
    age: 26,
  },
  {
    name: "Person7",
    age: 27,
  },
  {
    name: "Person8",
    age: 28,
  },
];

function ListComp() {
  return (
    <ScrollView>
      <Text>values are </Text>
      {persons.map((person) => (
        <View key={person.age} style={styles.list}>
          <Text>{person.name}</Text>
          <Text>{person.age}</Text>
        </View>
      ))}
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  list: {
    fontSize: 24,
    backgroundColor: "pink",
    margin: 30,
  },
});

export default ListComp;

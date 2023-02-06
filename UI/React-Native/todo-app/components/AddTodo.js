import React from "react";
import { Button, StyleSheet, Text, TextInput, View } from "react-native";

function AddTodo() {
  return (
  <View style={styles.input}>
    <TextInput placeholder="New todo.."/>
    <Button title="Add todo"/>
  </View>);
}

const styles = StyleSheet.create({
    input: {
      marginBottom: 10,
      paddingHorizontal: 10,
      paddingVertical: 10,
      borderBottomWidth: 1,
      borderBottomColor: "#ddd"
    },
  });

export default AddTodo;

import React from "react";
import { StyleSheet, Text, TouchableOpacity } from "react-native";

function TodoItem({ item }) {
  return (
    <TouchableOpacity>
      <Text style={styles.item}>{item.name}</Text>
    </TouchableOpacity>
  );
}

const styles = StyleSheet.create({
  item: {
   padding:16,
   marginTop: 16,
   borderWidth: 5,
   borderStyle: "solid",
   borderColor: "#bbb",
   borderRadius: 10
  },
});

export default TodoItem;

import React, { useState } from "react";
import { FlatList, StyleSheet, Text, View } from "react-native";
import TodoItem from "./TodoItem";

function TodoComponent({ item }) {
  return (
    <>
      <FlatList
        keyExtractor={(item) => item.key}
        data={item}
        renderItem={({ item }) => (
          <>
            <TodoItem item={item} />
          </>
        )}
      />
    </>
  );
}

const styles = StyleSheet.create({
  list: {
    padding: 20,
  },
});

export default TodoComponent;

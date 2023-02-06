import React from "react";
import { FlatList, StyleSheet, Text, View } from "react-native";
import TodoItem from "./TodoItem";

const todos = [
  {
    name: "Read the course",
    key: 1,
  },
  {
    name: "Practise the course",
    key: 2,
  },
  {
    name: "Teach the course",
    key: 3,
  },
];

function TodoComponent() {
  return (
    <>
      <FlatList
        keyExtractor={(item) => item.key}
        data={todos}
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

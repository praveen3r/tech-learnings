import React, { useState } from "react";
import { Alert, Button, StyleSheet, Text, TextInput, View } from "react-native";

function AddTodo({ submitHandler }) {
  const [todo, setTodo] = useState();

  const handleChange = (value) => {
    setTodo(value);
  };

  const handleSubmit = () => {
    submitHandler(todo);
  };

  return (
    <View style={styles.input}>
      <TextInput
        placeholder="New todo.."
        value={todo}
        onChangeText={handleChange}
      />
      <Button title="Add todo" onPress={handleSubmit} />
    </View>
  );
}

const styles = StyleSheet.create({
  input: {
    marginBottom: 10,
    paddingHorizontal: 10,
    paddingVertical: 10,
    borderBottomWidth: 1,
    borderBottomColor: "#ddd",
  },
});

export default AddTodo;

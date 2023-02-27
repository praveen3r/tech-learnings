import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import {
  StyleSheet,
  Text,
  SafeAreaView,
  View,
  Alert,
  TouchableWithoutFeedback,
  Keyboard,
} from "react-native";
import AddTodo from "./components/AddTodo";
import HeaderComponent from "./components/HeaderComponent";
import TodoComponent from "./components/TodoComponent";
import Sandbox from "./components/sandbox";

export default function App() {
  const [todos, setTodos] = useState([
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
  ]);

  const submitHandler = (todo) => {
    if (todo.length < 4) {
      Alert.alert("Error", "Todo must be atleast 4 chars long", [
        { text: "OK", onPress: () => console.log("OK Pressed") },
      ]);
    } else {
      setTodos((prevTodos) => {
        return [{ name: todo, key: Math.random().toString() }, ...prevTodos];
      });
    }
  };

  const handleOnPress = () => {
    Keyboard.dismiss();
  }

  return (
    //<Sandbox/>
    <TouchableWithoutFeedback onPress={handleOnPress}>
      <SafeAreaView style={styles.container}>
        <HeaderComponent />
        <View style={styles.content}>
          <AddTodo submitHandler={submitHandler} />
          <View style={styles.list}>
            <TodoComponent item={todos} />
          </View>
        </View>
      </SafeAreaView>
    </TouchableWithoutFeedback>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    //alignItems: 'center',
    //justifyContent: 'center',
  },
  content: {
    flex: 1,
    padding: 40,
    backgroundColor: "pink",
  },
  list: {
    flex: 1,
    padding: 20,
    backgroundColor: "yellow"
  },
});

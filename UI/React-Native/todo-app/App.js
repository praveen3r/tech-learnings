import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, SafeAreaView, View } from "react-native";
import AddTodo from "./components/AddTodo";
import HeaderComponent from "./components/HeaderComponent";
import TodoComponent from "./components/TodoComponent";

export default function App() {
  return (
    <SafeAreaView style={styles.container}>
      <HeaderComponent />
      <View>
        <AddTodo/>
        <View style={styles.list}>
          <TodoComponent />
        </View>
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    //alignItems: 'center',
    //justifyContent: 'center',
  },
  list: {
    padding: 20,
  },
});

import React from "react";
import { FlatList, StyleSheet, Text, View } from "react-native";
import VerticalCard from "../../components/card/VerticalCard";
import GlobalStyles from "../../components/style/GlobalStyles";
import { StackNavigationProps } from "../../types/ComponentType";

const cards = [
  { id: 1, title: "View/Edit Courses" },
  { id: 2, title: "Add Courses" },
  { id: 3, title: "View/Edit Softwares" },
  { id: 4, title: "Add Softwares" },
];

const Home = ({ navigation }: StackNavigationProps) => {
  const onPressHandler = (screenIndicator: number) => {
    switch (screenIndicator) {
      case 1:
        navigation.navigate("ViewCourse");
        break;
      case 2:
        navigation.navigate("AddCourse");
        break;
      case 3:
        navigation.navigate("ViewSoftware");
        break;
      case 4:
        navigation.navigate("AddSoftware");
        break;
    }
  };

  return (
    <View style={[styles.body, GlobalStyles.background]}>
      <View style={styles.container}>
        <Text style={[GlobalStyles.text, styles.welcomeText]}>
          Welcome, Praveen
        </Text>
        <Text style={[GlobalStyles.text, styles.text]}>
          What would you like to do today?
        </Text>
      </View>

      <FlatList
        numColumns={2}
        data={cards}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => (
          <VerticalCard
            title={item.title}
            onPressHandler={() => onPressHandler(item.id)}
          />
        )}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  body: {
    flex: 1,
  },
  container: {
    marginTop: 60,
  },
  welcomeText: {
    marginLeft: 10,
    marginBottom: 20,
    fontWeight: "bold",
    fontSize: 24,
  },
  text: {
    marginLeft: 10,
    fontSize: 16,
  },
});

export default Home;

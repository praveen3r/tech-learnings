import React from "react";
import { FlatList, Pressable, StyleSheet, Text, View } from "react-native";
import CardWithChild from "../../components/card/CardWithChild";
import { StackNavigationProps } from "../../types/ComponentType";
import { CourseType } from "../../types/FormType";

const courses: CourseType[] = [
  {
    name: "Angular",
    type: "Front End",
    value: "fntend",
    author: "Rengarajan Rengasamy",
  },
  {
    name: "ReactJS",
    type: "Front End",
    value: "fntend",
    author: "Rengarajan Rengasamy",
  },
  {
    name: "Spring boot",
    type: "Back End",
    value: "bkend",
    author: "Praveen Rajan",
  },
];

const ViewCourse = ({ navigation }: StackNavigationProps) => {
  const onPressHandler = (course: CourseType) => {
    navigation.navigate("EditCourse", course);
  };

  return (
    <View style={styles.container}>
      <FlatList
        data={courses}
        keyExtractor={(item) => item.name.toString()}
        renderItem={({ item }) => (
          <>
            <CardWithChild>
              <Pressable onPress={() => onPressHandler(item)}>
                <View style={styles.cardBody}>
                  <View style={styles.cardText}>
                    <Text style={styles.headerText}>Name</Text>
                  </View>
                  <View style={styles.cardText}>
                    <Text style={styles.text}>{item.name}</Text>
                  </View>
                  <View style={styles.cardText}>
                    <Text style={styles.headerText}>Type</Text>
                  </View>
                  <View style={styles.cardText}>
                    <Text style={styles.text}>{item.type}</Text>
                  </View>
                  <View style={styles.cardText}>
                    <Text style={styles.headerText}>Author</Text>
                  </View>
                  <View style={styles.cardText}>
                    <Text style={styles.text}>{item.author}</Text>
                  </View>
                </View>
              </Pressable>
            </CardWithChild>
          </>
        )}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    marginTop: 30,
    flex: 1,
    padding: 16,
  },
  headerText: {
    fontWeight: "bold",
    fontSize: 16,
    marginLeft: 20,
  },
  text: {
    fontSize: 14,
    marginLeft: 20,
    marginBottom: 20,
  },
  cardBody: {
    alignItems: "flex-start",
  },
  cardText: {
    flexDirection: "row",
    marginTop: 10,
  },
});

export default ViewCourse;

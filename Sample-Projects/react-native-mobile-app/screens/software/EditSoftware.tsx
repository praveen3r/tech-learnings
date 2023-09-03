import React from "react";
import { FlatList, StyleSheet, Text, View } from "react-native";
import CardWithChild from "../../components/card/CardWithChild";
import { SoftwareType } from "../../types/FormType";

const courses: SoftwareType[] = [
  {
    name: "Angular",
    type: "npm install",
    isExecutable: "No",
  },
  {
    name: "ReactJS",
    type: "npm install",
    isExecutable: "No",
  },
  {
    name: "MS Office",
    type: "exe",
    isExecutable: "Yes",
  },
];

const EditSoftware = () => {
  return (
    <View style={styles.container}>
      <FlatList
        data={courses}
        keyExtractor={(item) => item.name.toString()}
        renderItem={({ item }) => (
          <>
            <CardWithChild>
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
                  <Text style={styles.headerText}>Is Executable</Text>
                </View>
                <View style={styles.cardText}>
                  <Text style={styles.text}>{item.isExecutable}</Text>
                </View>
              </View>
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

export default EditSoftware;

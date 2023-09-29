import React from "react";
import { FlatList, Pressable, StyleSheet, Text, View } from "react-native";
import CardWithChild from "../../components/card/CardWithChild";
import { StackNavigationProps } from "../../types/ComponentType";
import { SoftwareType } from "../../types/FormType";

const softwares: SoftwareType[] = [
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

const ViewSoftware = ({ navigation }: StackNavigationProps) => {
  const onPressHandler = (software: SoftwareType) => {
    navigation.navigate("EditSoftware", software);
  };

  return (
    <View style={styles.container}>
      <FlatList
        data={softwares}
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
                    <Text style={styles.headerText}>Is Executable</Text>
                  </View>
                  <View style={styles.cardText}>
                    <Text style={styles.text}>{item.isExecutable}</Text>
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

export default ViewSoftware;

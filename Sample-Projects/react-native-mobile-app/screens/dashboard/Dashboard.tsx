import { createMaterialBottomTabNavigator } from "@react-navigation/material-bottom-tabs";
import React from "react";
import { StyleSheet, View } from "react-native";
import { FontAwesome } from "react-native-vector-icons";
import Home from "../Home/Home";
import Profile from "../Home/Profile";

const Tab = createMaterialBottomTabNavigator();

const Dashboard = () => {
  return (
    <>
      <View style={styles.header}>
        <FontAwesome name="bell" size={25} color="gold" />
        <FontAwesome name="user" size={30} color="gold" style={styles.icon} />
      </View>
      <Tab.Navigator>
        <Tab.Screen name="Home" component={Home} />
        <Tab.Screen name="Profile" component={Profile} />
      </Tab.Navigator>
    </>
  );
};

const styles = StyleSheet.create({
  header: {
    flexDirection: "row",
    justifyContent: "flex-end",
    alignItems: "flex-end",
    paddingTop: 20,
    paddingRight: 20,
    marginRight: 20,
  },
  icon: {
    marginLeft: 20,
  },
});

export default Dashboard;

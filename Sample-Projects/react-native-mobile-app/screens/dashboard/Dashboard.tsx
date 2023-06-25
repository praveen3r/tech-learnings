import { createDrawerNavigator } from "@react-navigation/drawer";
import React from "react";
import Home from "../Home/Home";
import Profile from "../Home/Profile";
import { createMaterialBottomTabNavigator } from "@react-navigation/material-bottom-tabs";

const Tab = createMaterialBottomTabNavigator();

function Dashboard() {
  return (
    <Tab.Navigator>
      <Tab.Screen name="Home" component={Home} />
      <Tab.Screen name="Profile" component={Profile} />
    </Tab.Navigator>
  );
}

export default Dashboard;

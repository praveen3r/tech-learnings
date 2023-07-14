import { createMaterialBottomTabNavigator } from "@react-navigation/material-bottom-tabs";
import React from "react";
import Home from "../Home/Home";
import Profile from "../Home/Profile";

const Tab = createMaterialBottomTabNavigator();

const Dashboard = () => {
  return (
    <Tab.Navigator>
      <Tab.Screen name="Home" component={Home} />
      <Tab.Screen name="Profile" component={Profile} />
    </Tab.Navigator>
  );
};

export default Dashboard;

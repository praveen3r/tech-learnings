import React from "react";
import { NavigationContainer } from '@react-navigation/native';
//import { createMaterialBottomTabNavigator } from '@react-navigation/material-bottom-tabs';
import { createMaterialTopTabNavigator } from '@react-navigation/material-top-tabs';
import ScreenA from './../screens/ScreenA';
import ScreenB from './../screens/ScreenB';
//import FontAwesome5 from 'react-native-vector-icons/FontAwesome5';


const Tab = createMaterialTopTabNavigator();

function BottomTabNav() {
  return (
    
    <NavigationContainer>
      <Tab.Navigator initialRouteName="Screen1">
        <Tab.Screen
          name="Screen1"
          component={Screen_A}
        />
        <Tab.Screen name="Screen2" component={Screen_B} />
      </Tab.Navigator>
    </NavigationContainer>
   
    
  );
}

export default BottomTabNav;

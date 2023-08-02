import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import React from "react";
import MpinSetup from "../screens/Mpin/MpinSetup";
import Dashboard from "../screens/dashboard/Dashboard";
import Helpdesk from "../screens/helpdesk/Helpdesk";
import ChangeKeyword from "../screens/login/ChangeKeyword";
import LoginErrPopUp from "../screens/login/LoginErrPopUp";
import Mpin from "../screens/login/Mpin";
import MyProfile from "../screens/profile/MyProfile";

const Stack = createStackNavigator();

function StackNav() {
  return (
    <NavigationContainer
      screenOptions={{
        cardStyle: {
          backgroundColor: "red",
        },
      }}
    >
      <Stack.Navigator
        initialRouteName="Login"
        screenOptions={{
          cardStyle: {
            backgroundColor: "blue",
          },
          headerTitleAlign: "center",
          headerStyle: {
            backgroundColor: "#0080ff",
          },
          headerTintColor: "#ffffff",
          headerTitleStyle: {
            fontSize: 25,
            fontWeight: "bold",
          },
        }}
      >
        <Stack.Screen
          name="Login"
          component={LoginErrPopUp}
          options={{
            headerShown: false,
          }}
        />
        <Stack.Screen
          name="Dashboard"
          component={Dashboard}
          options={{
            headerShown: false,
          }}
        />
        <Stack.Screen
          name="Mpin"
          component={Mpin}
          options={{
            headerShown: false,
          }}
        />
        <Stack.Screen
          name="MyProfile"
          component={MyProfile}
          options={{
            headerShown: false,
          }}
        />
        <Stack.Screen
          name="ChangeKeyword"
          component={ChangeKeyword}
          options={{
            headerShown: false,
          }}
        />
        <Stack.Screen
          name="MpinSetup"
          component={MpinSetup}
          options={{
            headerShown: false,
          }}
        />
        <Stack.Screen
          name="Helpdesk"
          component={Helpdesk}
          options={{
            headerShown: false,
          }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default StackNav;

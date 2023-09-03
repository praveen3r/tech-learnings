import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import React from "react";
import MpinSetup from "../screens/Mpin/MpinSetup";
import AddCourse from "../screens/course/AddCourse";
import EditCourse from "../screens/course/EditCourse";
import Dashboard from "../screens/dashboard/Dashboard";
import Helpdesk from "../screens/helpdesk/Helpdesk";
import ChangeKeyword from "../screens/login/ChangeKeyword";
import LoginErrPopUp from "../screens/login/LoginErrPopUp";
import Mpin from "../screens/login/Mpin";
import MyProfile from "../screens/profile/MyProfile";
import AddSoftware from "../screens/software/AddSoftware";
import EditSoftware from "../screens/software/EditSoftware";

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
            headerShown: true,
            headerTitle: "Personal Details",
          }}
        />
        <Stack.Screen
          name="ChangeKeyword"
          component={ChangeKeyword}
          options={{
            headerShown: true,
            headerTitle: "Change Password",
          }}
        />
        <Stack.Screen
          name="MpinSetup"
          component={MpinSetup}
          options={{
            headerShown: true,
            headerTitle: "Change mPIN",
          }}
        />
        <Stack.Screen
          name="Helpdesk"
          component={Helpdesk}
          options={{
            headerShown: true,
            headerTitle: "Help Desk",
          }}
        />
        <Stack.Screen
          name="AddCourse"
          component={AddCourse}
          options={{
            headerShown: true,
            headerTitle: "Add Course",
          }}
        />
        <Stack.Screen
          name="EditCourse"
          component={EditCourse}
          options={{
            headerShown: true,
            headerTitle: "Modify Course",
          }}
        />
        <Stack.Screen
          name="AddSoftware"
          component={AddSoftware}
          options={{
            headerShown: true,
            headerTitle: "Add Software",
          }}
        />
        <Stack.Screen
          name="EditSoftware"
          component={EditSoftware}
          options={{
            headerShown: true,
            headerTitle: "Modify Software",
          }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default StackNav;

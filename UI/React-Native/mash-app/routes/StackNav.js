import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import Home from './../screens/Home';
import Login from './../screens/Login';
import HomePush from '../screens/HomePush';
import GoogleMap from '../screens/GoogleMap';
import CameraTest from '../screens/CameraTest';

const Stack = createStackNavigator();

function StackNav() {
  return (
    <NavigationContainer>
      <Stack.Navigator
        initialRouteName="Login"
        screenOptions={{
          headerTitleAlign: 'center',
          headerStyle: {
            backgroundColor: '#0080ff'
          },
          headerTintColor: '#ffffff',
          headerTitleStyle: {
            fontSize: 25,
            fontWeight: 'bold'
          }
        }}
      >
        <Stack.Screen
          name="Login"
          component={Login}
          options={{
            headerShown: false,
          }}
        />
        <Stack.Screen
          name="Home"
          component={HomePush}
        />
        <Stack.Screen
          name="Map"
          component={GoogleMap}
        />
        <Stack.Screen
          name="Camera"
          component={CameraTest}
        />
      </Stack.Navigator>
    </NavigationContainer>
  )
}

export default StackNav
import { createStackNavigator } from '@react-navigation/stack';
import  Home from '../screens/Home';
import ReviewDetails  from '../screens/ReviewDetails';
import {NavigationContainer} from '@react-navigation/native';

const Stack = createStackNavigator();

const Routes = () => {
  return (
    <NavigationContainer>
    <Stack.Navigator initialRouteName={'Home'}>
      <Stack.Screen name="Home" component={Home} />
      <Stack.Screen name="ReviewDetails" component={ReviewDetails} />
    </Stack.Navigator>
    </NavigationContainer>
  );
};

export default Routes
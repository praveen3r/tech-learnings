import { createStackNavigator } from '@react-navigation/stack';
import  Home from '../screens/Home';
import ReviewDetails  from '../screens/ReviewDetails';
import {NavigationContainer} from '@react-navigation/native';
import About from '../screens/About';

const Stack = createStackNavigator();

const AboutStack = () => {
  return (
    <Stack.Navigator >
      <Stack.Screen name="About" component={About} />
      </Stack.Navigator>
  );
};

export default AboutStack
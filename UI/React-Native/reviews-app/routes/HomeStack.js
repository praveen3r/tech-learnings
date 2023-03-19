import { createStackNavigator } from '@react-navigation/stack';
import  Home from '../screens/Home';
import ReviewDetails  from '../screens/ReviewDetails';

const Stack = createStackNavigator();

const HomeStack = () => {
  return (
    <Stack.Navigator >
      <Stack.Screen name="Home" component={Home}/>
      <Stack.Screen name="ReviewDetails" component={ReviewDetails} />
      </Stack.Navigator>
  );
};

export default HomeStack
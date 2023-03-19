import About from "../screens/About";
import Home from "../screens/Home";
import { createDrawerNavigator } from '@react-navigation/drawer';
import { NavigationContainer } from "@react-navigation/native";
import HomeStack from "./HomeStack";
import AboutStack from "./AboutStack";
import Header from '../screens/Header'

const Drawer = createDrawerNavigator();

const DrawerRoutes = () => {
    return (
      <NavigationContainer>
      <Drawer.Navigator>
        <Drawer.Screen name="HomeStack" component={HomeStack} options={{ headerTitle: (navigation) => <Header navigation={navigation} /> }} />
        <Drawer.Screen name="AboutStack" component={AboutStack} options={{ headerTitle: (navigation) => <Header navigation={navigation}/> }}/>
      </Drawer.Navigator>
      </NavigationContainer>
    );
  };
  
  export default DrawerRoutes
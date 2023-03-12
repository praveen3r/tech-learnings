import About from "../screens/About";
import Home from "../screens/Home";
import { createDrawerNavigator } from '@react-navigation/drawer';
import { NavigationContainer } from "@react-navigation/native";
import HomeStack from "./HomeStack";
import AboutStack from "./AboutStack";

const Drawer = createDrawerNavigator();

const DrawerRoutes = () => {
    return (
      <NavigationContainer>
      <Drawer.Navigator>
        <Drawer.Screen name="HomeStack" component={HomeStack} />
        <Drawer.Screen name="AboutStack" component={AboutStack} />
      </Drawer.Navigator>
      </NavigationContainer>
    );
  };
  
  export default DrawerRoutes
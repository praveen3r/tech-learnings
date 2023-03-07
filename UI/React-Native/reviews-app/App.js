import { StatusBar } from 'expo-status-bar';
import { SafeAreaView, StyleSheet, Text, View } from 'react-native';
//import Home from './screens/Home';
import { useFonts } from 'expo-font';
import * as SplashScreen from 'expo-splash-screen';
import { useCallback } from 'react';
import globalStyles from './styles/Global';
import Routes from './routes/Routes'
//import Home from './routes/Routes/Home';


export default function App() {
  const [fontsLoaded] = useFonts({
    'nunito-bold': require('./assets/fonts/Nunito-Bold.ttf'),
  });

  const onLayoutRootView = useCallback(async () => {
    if (fontsLoaded) {
      await SplashScreen.hideAsync();
    }
  }, [fontsLoaded]);

  if (!fontsLoaded) {
    return null;
  }

  return (
     <SafeAreaView style={globalStyles.container}>
      {/* <Home/> */}
      <Routes />
      </SafeAreaView>
    );
}





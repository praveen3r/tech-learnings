import { StatusBar } from 'expo-status-bar';
import { Platform, SafeAreaView, StyleSheet, Text, View } from 'react-native';
import SectionListComp from './basic/SectionListComp';
import ScrollViewWithRefresh from './basic/ScrollViewWithRefresh';
import TestPressable from './basic/TestPressable';
import TestModal from './basic/TestModal';
import BottomTabNav from './routes/BottomTabNav';
import StackNav from './routes/StackNav';

export default function App() {
  return (
    <>
    {/*<SafeAreaView style={styles.container}>
     <ScrollViewWithRefresh/>
    // <SectionListComp/>
    <TestPressable/>
    <TestModal/>
    
    </SafeAreaView>
    <BottomTabNav/>*/}
    <StackNav/>
    </>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 20,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
    paddingTop: Platform.OS === "android" ? StatusBar.currentHeight : 0,
  },
});

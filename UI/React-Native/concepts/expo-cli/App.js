import { useDeviceOrientation } from "@react-native-community/hooks";
import { Platform, SafeAreaView, StatusBar, StyleSheet } from "react-native";
import FlatListComp from "./components/basic/FlatListComp";

export default function App() {
  const { landscape } = useDeviceOrientation();

  return (
    <SafeAreaView
      style={[styles.container, { height: landscape ? "100%" : "20%" }]}
    >
      {/* <TextComp></TextComp>
      <ImageComp></ImageComp> 

      <ButtonComp />
      <AlertComp /> 
      <StateComp />
      <TextInputComp />*/}
      <FlatListComp />
      <StatusBar style="auto" />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
    paddingTop: Platform.OS === "android" ? StatusBar.currentHeight : 0,
  },
});

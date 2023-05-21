import { FontAwesome } from "@expo/vector-icons/";
import AsyncStorage from "@react-native-async-storage/async-storage";
import React, { useEffect, useState } from "react";
import { Alert, StyleSheet, Text, View } from "react-native";
import CustomButton from "../../components/button/CustomButton";
import InputComponentWithIcon from "../../components/formik/InputComponentWithIcon";
import { StackNavigationProps } from "../../types/ComponentType";

export default function Login({ navigation }: StackNavigationProps) {
  const [userId, setUserId] = useState("");
  const [keyword, setKeyword] = useState("");

  useEffect(() => {
    getData();
  }, []);

  const getData = () => {
    try {
      AsyncStorage.getItem("UserData").then((value) => {
        if (value != null) {
          navigation.navigate("Home");
        }
      });
    } catch (error) {
      console.log(error);
    }
  };

  const setData = async () => {
    if (userId.length == 0 || keyword.length == 0) {
      Alert.alert("Warning!", "Please write your data.");
    } else {
      try {
        var user = {
          Name: userId,
          Age: keyword,
        };
        await AsyncStorage.setItem("UserData", JSON.stringify(user));
        navigation.navigate("Home");
      } catch (error) {
        console.log(error);
      }
    }
  };

  return (
    <View style={styles.body}>
      {/* <Image
                style={styles.logo}
                source={require('../assets/asyncstorage.png')}
            /> */}

      <Text style={styles.text}>Login to your account</Text>
      <View style={styles.input}>
        <FontAwesome name={"user"} size={28} style={styles.icon} />

        <InputComponentWithIcon
          dataType="text"
          placeholder="EMAIL OR PHONE"
          onChangeText={(value) => setUserId(value)}
        />
      </View>
      <View style={styles.input}>
        <FontAwesome name={"lock"} size={28} style={styles.icon} />

        <InputComponentWithIcon
          dataType="keyword"
          placeholder="PASSWORD"
          onChangeText={(value) => setKeyword(value)}
        />
      </View>

      <CustomButton
        title="Login"
        onPressFunction={setData}
        style={styles.button}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  body: {
    flex: 1,
    alignItems: "center",
    backgroundColor: "#0080ff",
  },
  logo: {
    width: 100,
    height: 100,
    margin: 20,
  },
  text: {
    fontSize: 20,
    color: "#ffffff",
    marginTop: 200,
    marginBottom: 30,
  },
  input: {
    flexDirection: "row",
    width: 300,
    borderWidth: 1,
    borderColor: "#555",
    borderRadius: 10,
    backgroundColor: "#ffffff",
    marginBottom: 25,
    height: 50,
  },
  icon: {
    paddingTop: 10,
    paddingLeft: 10,
  },
  button: {
    marginTop: 50,
  },
});

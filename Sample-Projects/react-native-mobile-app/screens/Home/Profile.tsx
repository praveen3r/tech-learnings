import {
  AntDesign,
  Feather,
  Foundation,
  Ionicons,
  SimpleLineIcons,
} from "@expo/vector-icons";

import React from "react";
import { StyleSheet, Text, View } from "react-native";

function Profile() {
  return (
    <View style={styles.body}>
      <View style={styles.text}>
        <AntDesign name="user" size={30} color="gold" />
        <Text style={styles.innerText}>Profile</Text>
      </View>
      <View style={styles.text}>
        <Foundation name="key" size={30} color="gold" />
        <Text style={styles.innerText}>Change Password</Text>
      </View>
      <View style={styles.text}>
        <Feather name="lock" size={30} color="gold" />
        <Text style={styles.innerText}>MPIN Setup</Text>
      </View>
      <View style={styles.text}>
        <Ionicons name="information-circle-outline" size={30} color="gold" />
        <Text style={styles.innerText}>Help Desk</Text>
      </View>
      <View style={styles.text}>
        <SimpleLineIcons name="logout" size={30} color="gold" />
        <Text style={styles.innerText}>Logout</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  body: {
    flex: 1,
    marginTop: 60,
    justifyContent: "center",
    alignItems: "center",
  },
  text: {
    flex: 1,
    flexDirection: "row",
    marginTop: 70,
    marginLeft: 10,
    borderWidth: 1,
    borderColor: "black",
    paddingLeft: 10,
    paddingTop: 10,
    width: "95%",
  },
  innerText: {
    marginLeft: 20,
    fontSize: 20,
  },
});

export default Profile;

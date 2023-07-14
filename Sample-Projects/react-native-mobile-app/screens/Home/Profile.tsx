import {
  AntDesign,
  Feather,
  Foundation,
  Ionicons,
  MaterialIcons,
  SimpleLineIcons,
} from "@expo/vector-icons";

import React, { useState } from "react";
import { Pressable, StyleSheet, Text, View } from "react-native";
import { StackNavigationProps } from "../../types/ComponentType";
import CustomModal from "../../components/modal/CustomModal";

const Profile = ({ navigation }: StackNavigationProps) => {
  const [logoutPopUpVisible, setLogoutPopUpVisible] = useState<boolean>(false);

  const onPressLogoutHandler = () => {
    setLogoutPopUpVisible(true);
  };

  const onCloseModal = (isOkClicked: boolean) => {
    setLogoutPopUpVisible(false);
    if (isOkClicked) {
      navigation.navigate("Login");
    }
  };

  return (
    <View style={styles.body}>
      <View style={styles.card}>
        <AntDesign name="user" size={30} color="gold" />
        <View style={styles.cardBody}>
          <Text style={styles.text}>Profile</Text>
        </View>
        <MaterialIcons
          name="keyboard-arrow-right"
          size={30}
          color="black"
          style={styles.arrow}
        />
      </View>
      <View style={styles.card}>
        <Foundation name="key" size={30} color="gold" />
        <View style={styles.cardBody}>
          <Text style={styles.text}>Change Password</Text>
        </View>
        <MaterialIcons
          name="keyboard-arrow-right"
          size={30}
          color="black"
          style={styles.arrow}
        />
      </View>
      <View style={styles.card}>
        <Feather name="lock" size={30} color="gold" />
        <View style={styles.cardBody}>
          <Text style={styles.text}>MPIN Setup</Text>
        </View>
        <MaterialIcons
          name="keyboard-arrow-right"
          size={30}
          color="black"
          style={styles.arrow}
        />
      </View>
      <View style={styles.card}>
        <Ionicons name="information-circle-outline" size={30} color="gold" />
        <View style={styles.cardBody}>
          <Text style={styles.text}>Help Desk</Text>
        </View>
        <MaterialIcons
          name="keyboard-arrow-right"
          size={30}
          color="black"
          style={styles.arrow}
        />
      </View>
      <Pressable onPress={onPressLogoutHandler}>
        <View style={styles.card}>
          <SimpleLineIcons name="logout" size={30} color="gold" />
          <View style={styles.cardBody}>
            <Text style={styles.text}>Logout</Text>
          </View>
          <MaterialIcons
            name="keyboard-arrow-right"
            size={30}
            color="black"
            style={styles.arrow}
          />
        </View>
      </Pressable>
      <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
        <CustomModal
          visible={logoutPopUpVisible}
          onRequestClose={onCloseModal}
          data="Are you sure you want to logout?"
        />
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  body: {
    flex: 1,
    marginTop: 60,
    justifyContent: "center",
    alignItems: "center",
  },
  card: {
    flexDirection: "row",
    marginTop: 70,
    marginLeft: 10,
    borderWidth: 1,
    borderColor: "black",
    paddingLeft: 10,
    paddingTop: 10,
    width: "95%",
    height: 50,
  },
  cardBody: {
    flex: 1,
  },
  text: {
    marginLeft: 20,
    fontSize: 20,
  },
  arrow: {
    paddingRight: 20,
  },
});

export default Profile;

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
import CustomModal from "../../components/modal/CustomModal";
import { StackNavigationProps } from "../../types/ComponentType";

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

  const onPressHandler = (screenIndicator: number) => {
    switch (screenIndicator) {
      case 1:
        navigation.navigate("MyProfile");
        break;
      case 2:
        navigation.navigate("ChangeKeyword");
        break;
      case 3:
        navigation.navigate("MpinSetup");
        break;
      case 4:
        navigation.navigate("Helpdesk");
        break;
    }
  };

  return (
    <View style={styles.body}>
      <View style={[styles.card, styles.cardHeader]}>
        <View style={styles.cardBody}>
          <Text style={styles.headerText}>Praveen Rajan</Text>
        </View>
      </View>

      <Pressable onPress={() => onPressHandler(1)}>
        <View style={[styles.card, styles.cardChild]}>
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
      </Pressable>
      <Pressable onPress={() => onPressHandler(2)}>
        <View style={[styles.card, styles.cardChild]}>
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
      </Pressable>
      <Pressable onPress={() => onPressHandler(3)}>
        <View style={[styles.card, styles.cardChild]}>
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
      </Pressable>
      <Pressable onPress={() => onPressHandler(4)}>
        <View style={[styles.card, styles.cardChild]}>
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
      </Pressable>
      <Pressable onPress={onPressLogoutHandler}>
        <View style={[styles.card, styles.cardChild]}>
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
      <View style={styles.modalContainer}>
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
    justifyContent: "center",
    alignItems: "center",
  },
  card: {
    flexDirection: "row",
    marginTop: 40,
    marginLeft: 10,
    borderWidth: 1,
    borderColor: "black",
    width: "95%",
  },
  cardHeader: {
    height: 80,
    alignItems: "center",
    justifyContent: "center",
  },
  cardChild: {
    height: 50,
    paddingLeft: 10,
    paddingTop: 10,
  },
  cardBody: {
    flex: 1,
  },
  text: {
    marginLeft: 20,
    fontSize: 20,
  },
  headerText: {
    fontSize: 20,
  },
  arrow: {
    paddingRight: 20,
  },
  modalContainer: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
});

export default Profile;

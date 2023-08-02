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
import CircleText from "../../components/custom/CircleText";
import CustomModal from "../../components/modal/CustomModal";
import GlobalStyles from "../../components/style/GlobalStyles";
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
    <View style={[GlobalStyles.body, GlobalStyles.background]}>
      <View style={[GlobalStyles.card, GlobalStyles.cardHeader]}>
        <View style={GlobalStyles.cardBody}>
          <View style={styles.circleText}>
            <CircleText text="PR" radius={20} />
          </View>
          <Text style={[styles.headerText, GlobalStyles.textColor]}>
            Praveen Rajan
          </Text>
        </View>
      </View>

      <Pressable onPress={() => onPressHandler(1)}>
        <View style={[GlobalStyles.card, GlobalStyles.cardChild]}>
          <AntDesign name="user" size={30} color="gold" />
          <View style={GlobalStyles.cardBody}>
            <Text style={GlobalStyles.text}>Profile</Text>
          </View>
          <MaterialIcons
            name="keyboard-arrow-right"
            size={30}
            color="black"
            style={GlobalStyles.arrow}
          />
        </View>
      </Pressable>
      <Pressable onPress={() => onPressHandler(2)}>
        <View style={[GlobalStyles.card, GlobalStyles.cardChild]}>
          <Foundation name="key" size={30} color="gold" />
          <View style={GlobalStyles.cardBody}>
            <Text style={GlobalStyles.text}>Change Password</Text>
          </View>
          <MaterialIcons
            name="keyboard-arrow-right"
            size={30}
            color="black"
            style={GlobalStyles.arrow}
          />
        </View>
      </Pressable>
      <Pressable onPress={() => onPressHandler(3)}>
        <View style={[GlobalStyles.card, GlobalStyles.cardChild]}>
          <Feather name="lock" size={30} color="gold" />
          <View style={GlobalStyles.cardBody}>
            <Text style={GlobalStyles.text}>MPIN Setup</Text>
          </View>
          <MaterialIcons
            name="keyboard-arrow-right"
            size={30}
            color="black"
            style={GlobalStyles.arrow}
          />
        </View>
      </Pressable>
      <Pressable onPress={() => onPressHandler(4)}>
        <View style={[GlobalStyles.card, GlobalStyles.cardChild]}>
          <Ionicons name="information-circle-outline" size={30} color="gold" />
          <View style={GlobalStyles.cardBody}>
            <Text style={GlobalStyles.text}>Help Desk</Text>
          </View>
          <MaterialIcons
            name="keyboard-arrow-right"
            size={30}
            color="black"
            style={GlobalStyles.arrow}
          />
        </View>
      </Pressable>
      <Pressable onPress={onPressLogoutHandler}>
        <View style={[GlobalStyles.card, GlobalStyles.cardChild]}>
          <SimpleLineIcons name="logout" size={30} color="gold" />
          <View style={GlobalStyles.cardBody}>
            <Text style={GlobalStyles.text}>Logout</Text>
          </View>
          <MaterialIcons
            name="keyboard-arrow-right"
            size={30}
            color="black"
            style={GlobalStyles.arrow}
          />
        </View>
      </Pressable>
      <View style={GlobalStyles.modalContainer}>
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
  circleText: {
    marginLeft: 10,
  },
  headerText: {
    fontSize: 25,
    marginLeft: 15,
  },
});

export default Profile;

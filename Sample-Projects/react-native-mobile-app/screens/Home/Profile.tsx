import {
  AntDesign,
  Feather,
  Foundation,
  Ionicons,
  SimpleLineIcons,
} from "@expo/vector-icons";

import React, { useState } from "react";
import { StyleSheet, Text, View } from "react-native";
import HorizontalCard from "../../components/card/HorizontalCard";
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

      <HorizontalCard title="Profile" onPressHandler={() => onPressHandler(1)}>
        <AntDesign name="user" size={30} color="gold" />
      </HorizontalCard>

      <HorizontalCard
        title="Change Password"
        onPressHandler={() => onPressHandler(2)}
      >
        <Foundation name="key" size={30} color="gold" />
      </HorizontalCard>

      <HorizontalCard
        title="MPIN Setup"
        onPressHandler={() => onPressHandler(3)}
      >
        <Feather name="lock" size={30} color="gold" />
      </HorizontalCard>

      <HorizontalCard
        title="Help Desk"
        onPressHandler={() => onPressHandler(4)}
      >
        <Ionicons name="information-circle-outline" size={30} color="gold" />
      </HorizontalCard>

      <HorizontalCard title="Logout" onPressHandler={onPressLogoutHandler}>
        <SimpleLineIcons name="logout" size={30} color="gold" />
      </HorizontalCard>

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

import { AntDesign, MaterialIcons, Octicons } from "@expo/vector-icons";
import React, { useState } from "react";
import { Pressable, StyleSheet, Text, View } from "react-native";
import CircleText from "../../components/custom/CircleText";
import GlobalStyles from "../../components/style/GlobalStyles";

const MyProfile = () => {
  const [isProfileExpanded, setProfileExpanded] = useState<boolean>(false);
  const [isAddressExpanded, setAddressExpanded] = useState<boolean>(false);

  const onPressHandler = (screenIndicator: number) => {
    switch (screenIndicator) {
      case 1:
        setProfileExpanded(!isProfileExpanded);
        break;
      case 2:
        setAddressExpanded(!isAddressExpanded);
        break;
    }
  };

  return (
    <View style={styles.body}>
      <View style={[GlobalStyles.card, styles.headerCardChild]}>
        <View style={GlobalStyles.cardBody}>
          <View style={styles.circleText}>
            <CircleText text="PR" radius={40} />
          </View>
        </View>
      </View>
      <Pressable onPress={() => onPressHandler(1)}>
        <View style={[GlobalStyles.card, GlobalStyles.cardChild]}>
          <AntDesign name="user" size={30} color="gold" />
          <View style={GlobalStyles.cardBody}>
            <Text style={GlobalStyles.text}>My Profile</Text>
          </View>
          <MaterialIcons
            name={
              isProfileExpanded ? "keyboard-arrow-down" : "keyboard-arrow-right"
            }
            size={30}
            color="black"
            style={GlobalStyles.arrow}
            a
          />
        </View>
        {isProfileExpanded && (
          <>
            <View style={[styles.card, styles.cardChild]}>
              <View style={styles.cardBody}>
                <Text style={styles.text}>Praveen Rajan</Text>
                <Text style={styles.label}>Name</Text>
              </View>
            </View>
            <View style={[styles.card, styles.cardChild]}>
              <View style={styles.cardBody}>
                <Text style={styles.text}>9********4</Text>
                <Text style={styles.label}>Mobile</Text>
              </View>
            </View>
            <View style={[styles.card, styles.cardChild]}>
              <View style={styles.cardBody}>
                <Text style={styles.text}>111111</Text>
                <Text style={styles.label}>Employee Id</Text>
              </View>
            </View>
          </>
        )}
      </Pressable>
      <Pressable onPress={() => onPressHandler(2)}>
        <View style={[GlobalStyles.card, GlobalStyles.cardChild]}>
          <Octicons name="note" size={30} color="gold" />
          <View style={GlobalStyles.cardBody}>
            <Text style={GlobalStyles.text}>My Address</Text>
          </View>
          <MaterialIcons
            name={
              isAddressExpanded ? "keyboard-arrow-down" : "keyboard-arrow-right"
            }
            size={30}
            color="black"
            style={GlobalStyles.arrow}
          />
        </View>

        {isAddressExpanded && (
          <>
            <View style={[styles.card, styles.addressCardChild]}>
              <View style={styles.cardBody}>
                <Text style={styles.text}>111, Beautiful Apartment</Text>
                <Text style={styles.text}>Texas main road, Texas</Text>
                <Text style={styles.text}>Chicago, USA - 600000</Text>
              </View>
            </View>
          </>
        )}
      </Pressable>
    </View>
  );
};

const styles = StyleSheet.create({
  body: {
    flex: 1,
    alignItems: "flex-start",
  },
  card: {
    flexDirection: "row",
    marginTop: 10,
    marginLeft: 50,
    borderWidth: 1,
    borderColor: "black",
    width: "85%",
  },

  cardChild: {
    height: 70,
    paddingLeft: 10,
    paddingTop: 10,
  },
  addressCardChild: {
    height: 100,
    paddingLeft: 10,
    paddingTop: 10,
  },
  cardBody: {
    flex: 1,
  },
  text: {
    fontWeight: "bold",
    marginLeft: 20,
    fontSize: 20,
    color: "#ffffff",
  },
  label: {
    marginLeft: 20,
    fontSize: 16,
    color: "#ffffff",
  },
  circleText: {
    marginLeft: 10,
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  headerCardChild: {
    height: 100,
    paddingLeft: 10,
    paddingTop: 10,
  },
});

export default MyProfile;

import { MaterialIcons } from "@expo/vector-icons";
import React from "react";
import { Pressable, Text, View } from "react-native";
import GlobalStyles from "../style/GlobalStyles";

const HorizontalCard = (props: any) => {
  return (
    <Pressable onPress={() => props.onPressHandler()}>
      <View style={[GlobalStyles.card, GlobalStyles.cardChild]}>
        {props.children}
        <View style={GlobalStyles.cardBody}>
          <Text style={GlobalStyles.text}>{props.title}</Text>
        </View>
        <MaterialIcons
          name="keyboard-arrow-right"
          size={30}
          color="black"
          style={GlobalStyles.arrow}
        />
      </View>
    </Pressable>
  );
};

export default HorizontalCard;

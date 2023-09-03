import { FontAwesome } from "@expo/vector-icons";
import React from "react";
import { Pressable, Text, View } from "react-native";
import GlobalStyles from "../style/GlobalStyles";

const VerticalCard = (props: any) => {
  return (
    <Pressable onPress={() => props.onPressHandler()}>
      <View
        style={[GlobalStyles.horizontalCard, GlobalStyles.horizontalCardChild]}
      >
        <FontAwesome name="bell" size={25} color="gold" />
        <View style={GlobalStyles.cardBody}>
          <Text style={GlobalStyles.text}>{props.title}</Text>
        </View>
      </View>
    </Pressable>
  );
};

export default VerticalCard;

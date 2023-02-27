import React from "react";
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";
import { MaterialIcons } from '@expo/vector-icons'; 

function TodoItem({ item }) {
  return (
    <TouchableOpacity>
      <View style={styles.item}> 
      <Text style={styles.itemText}>{item.name}</Text>
      <MaterialIcons name="delete" size={24} color="black" />
      </View>
    </TouchableOpacity>
  );
}

const styles = StyleSheet.create({
  item: {
   padding:16,
   marginTop: 16,
   borderWidth: 5,
   borderStyle: "solid",
   borderColor: "#bbb",
   borderRadius: 10,
   flexDirection: 'row'
  },
  itemText: {
    marginRight: 10
  }
});

export default TodoItem;

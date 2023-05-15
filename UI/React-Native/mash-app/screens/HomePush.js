import React, { useEffect } from "react";
import {
  StyleSheet,
  View,
  Text,
  FlatList,
  TouchableOpacity,
} from "react-native";
import GlobalStyle from "./../utils/GlobalStyle";
import CustomButton from "./../utils/CustomButton";

const cities = [
  {
    country: "India",
    city: "Chennai",
    key: 21,
  },
  {
    country: "USA",
    city: "New york",
    key: 22,
  },
  {
    country: "Germany",
    city: "Berlin",
    key: 23,
  },
  {
    country: "Australia",
    city: "Melbourne",
    key: 24,
  },
];

function HomePush({ navigation }) {
  return (
    <View style={styles.body}>
      <Text style={styles.text}>
        Welcome !
      </Text>
      <CustomButton
                title="Open Camera"
                color='#0080ff'
                onPressFunction={() => { navigation.navigate('Camera') }}
            />
      <FlatList
        data={cities}
        renderItem={({ item, index }) => (
          <TouchableOpacity
            onPress={() => {
              navigation.navigate('Map', {
                city: item.city,
                lat: item.lat,
                lng: item.lng,
            });
            }}
          >
            <View style={styles.item}>
              <Text style={styles.title}>{item.country}</Text>
              <Text style={styles.subtitle}>{item.city}</Text>
            </View>
          </TouchableOpacity>
        )}
        keyExtractor={(item, index) => index.toString()}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  body: {
    flex: 1,
    alignItems: "center",
  },
  text: {
    fontSize: 40,
    margin: 10,
  },
  input: {
    width: 300,
    borderWidth: 1,
    borderColor: "#555",
    borderRadius: 10,
    backgroundColor: "#ffffff",
    textAlign: "center",
    fontSize: 20,
    marginTop: 130,
    marginBottom: 10,
  },
  item: {
    backgroundColor: "#ffffff",
    borderWidth: 2,
    borderColor: "#cccccc",
    borderRadius: 5,
    margin: 7,
    width: 350,
    justifyContent: "center",
    alignItems: "center",
  },
  title: {
    fontSize: 30,
    margin: 10,
  },
  subtitle: {
    fontSize: 20,
    margin: 10,
    color: "#999999",
  },
});

export default HomePush;

import AsyncStorage from "@react-native-async-storage/async-storage";
import React, { useEffect, useState } from "react";
import { Text, View } from "react-native";

function Dashboard() {
  const [name, setName] = useState<String>(null);

  useEffect(() => {
    getData();
  }, []);

  const getData = () => {
    try {
      AsyncStorage.getItem("UserData").then((value) => {
        if (value != null) {
          const user = JSON.parse(value);
          const name = user.name;
          setName(name);
        }
      });
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <View>
      <Text>Welcome to Dashboard {name}</Text>
    </View>
  );
}

export default Dashboard;

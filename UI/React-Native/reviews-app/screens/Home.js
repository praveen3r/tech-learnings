import React from 'react'
import { Button, FlatList, StyleSheet, Text, View } from 'react-native'
import { TouchableOpacity } from 'react-native-gesture-handler';
import globalStyles from '../styles/Global';

function Home(props) {

  const { navigation } = props;

  const persons = [
    {
      name: "Person1",
      age: 21,
      key: 21,
    },
    {
      name: "Person2",
      age: 22,
      key: 22,
    },
    {
      name: "Person3",
      age: 23,
      key: 23,
    }
  ];

  const onPressHandler = () => {
    navigation.navigate('ReviewDetails');
  }

  const onPressOpacity = (item) => {
    navigation.navigate('ReviewDetails',{item}); //works for stack navigator only
  }

  return (
    <View style={globalStyles.container}>
    <Text style={globalStyles.text}>Home</Text>
    {/* <Button title='Go to reviews' onPress={() => navigation.navigate('ReviewDetails')}/> */}
    <Button title='Go to reviews' onPress={onPressHandler}/>

    <FlatList
      keyExtractor={(item) => item.age}
      data={persons}
      renderItem={({ item }) => (
        <TouchableOpacity onPress={() => onPressOpacity(item)}>
          <Text style={globalStyles.text}>{item.name}</Text>
          
        </TouchableOpacity>
      )}
    />
  </View>
  )
}

export default Home
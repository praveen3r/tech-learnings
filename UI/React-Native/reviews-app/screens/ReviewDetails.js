import React from 'react'
import { Button, StyleSheet, Text, View } from 'react-native'

function ReviewDetails(props) {

  const { navigation, route } = props;
  const { item } = route.params;

  const onPressHandler = () => {
    navigation.goBack();
  }

  return (
    <View style={styles.container}>
    <Text>Name: {item.name}</Text> 
    <Text>Age: {item.age}</Text>
    <Button title='Go back' onPress={onPressHandler}/>
  </View>
  )
}

const styles = StyleSheet.create({
  container: {
    padding: 25,
  }  
});

export default ReviewDetails
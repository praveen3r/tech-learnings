import React from 'react'
import { Button, Image, StyleSheet, Text, View } from 'react-native'

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
    <View style={styles.rating}>
    <Text>GameZone rating: </Text>
          <Image source={require('./../assets/rating-1.png')} />
    </View>
    <Button title='Go back' onPress={onPressHandler}/>
  </View>
  )
}

const styles = StyleSheet.create({
  container: {
    padding: 25,
  }  ,
  rating: {
    flexDirection: 'row',
    justifyContent: 'center',
    paddingTop: 16,
    marginTop: 16,
    borderTopWidth: 1,
    borderTopColor: '#eee',
  }
});

export default ReviewDetails
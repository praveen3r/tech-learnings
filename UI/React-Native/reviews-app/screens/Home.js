import React, { useState } from 'react'
import { Button, FlatList, Keyboard, Modal, StyleSheet, Text, TouchableWithoutFeedback, View } from 'react-native'
import { TouchableOpacity } from 'react-native-gesture-handler';
import globalStyles from '../styles/Global';
import Card from './Card';
import { MaterialIcons } from '@expo/vector-icons'; 
import ReviewForm from './ReviewForm';

function Home(props) {

  const [modalOpen, setModalOpen] = useState(false);

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

  const addReview = (review) => {
    //review.key = Math.random().toString();
    // setReviews((currentReviews) => {
    //   return [review, ...currentReviews];
    // });
    //persons.push(review);
    setModalOpen(false);
  };

  return (
    <View style={globalStyles.container}>
      <Modal visible={modalOpen} animationType='slide'>
      <TouchableWithoutFeedback onPress={Keyboard.dismiss}>
        <View style={styles.modalContent}>
          <MaterialIcons 
            name='close'
            size={24} 
            style={{...styles.modalToggle, ...styles.modalClose}} 
            onPress={() => setModalOpen(false)} 
          />
          <ReviewForm addReview={addReview}/>
        </View>
        </TouchableWithoutFeedback>
      </Modal>

      <MaterialIcons 
        name='add' 
        size={24} 
        style={styles.modalToggle}
        onPress={() => setModalOpen(true)} 
      />

    <Text style={globalStyles.text}>Home</Text>
    {/* <Button title='Go to reviews' onPress={() => navigation.navigate('ReviewDetails')}/> */}
    <Button title='Go to reviews' onPress={onPressHandler}/>

    <FlatList
      keyExtractor={(item) => item.age}
      data={persons}
      renderItem={({ item }) => (
        <TouchableOpacity onPress={() => onPressOpacity(item)}>
          {/* <Text style={globalStyles.text}>{item.name}</Text> */}
          <Card>
          <Text style={globalStyles.text}>{item.name}</Text>
          </Card>
        </TouchableOpacity>
      )}
    />
  </View>
  )
}

const styles = StyleSheet.create({
  modalToggle: {
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 10,
    borderWidth: 1,
    borderColor: '#f2f2f2',
    padding: 10,
    borderRadius: 10,
    alignSelf: 'center',
  },
  modalClose: {
    marginTop: 20,
    marginBottom: 0,
  },
  modalContent: {
    flex: 1,
  }
});

export default Home
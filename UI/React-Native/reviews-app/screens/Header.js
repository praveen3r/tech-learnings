import React from 'react'
import { Image, ImageBackground, StyleSheet, Text, View } from 'react-native'
import { MaterialIcons } from '@expo/vector-icons'; 
import { DrawerActions, useNavigation } from '@react-navigation/native';

function Header() {

    const navigation = useNavigation(); 

 const openMenu = () => {
    navigation.openDrawer();
    //navigation.dispatch(DrawerActions.openDrawer());
    //navigation.actions.openDrawer();
 }

  return (
    <ImageBackground source={require('../assets/game_bg.png')} style={styles.header}>
    <View style={styles.header}>
        <MaterialIcons name='menu' size={28} onPress={openMenu} styles={styles.icon}/>
        <View style={styles.headerTitle}>
        <Image source={require('../assets/heart_logo.png')} style={styles.headerImage} />
        <Text style={styles.headerText}>Title</Text>
      </View>
    </View>
    </ImageBackground>
  )
}

const styles = StyleSheet.create({
    header: {
        width: '100%',
        height: '100%',
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: 'red'
    },
    headerText: {
        fontWeight: 'bold',
        fontSize: 20,
        color: '#333',
        letterSpacing: 1
    },
    icon: {
        position: 'absolute',
        left: 16
    },
    headerTitle: {
        flexDirection: 'row'
      },
      headerImage: {
        width: 26,
        height: 26,
        marginHorizontal: 10
      },
})

export default Header
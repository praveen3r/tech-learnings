import { StyleSheet } from "react-native";

const globalStyles = StyleSheet.create({
    container: {
      flex: 1,
      padding: 25,
    } , 
    text:{
      fontFamily: 'nunito-bold',
      fontSize: 18,
      color: '#333'

    },
    paragraph: {
        marginVertical: 8,
        lineHeight: 20
    }
  });

export default globalStyles;
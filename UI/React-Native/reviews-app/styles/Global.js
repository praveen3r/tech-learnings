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
    },
    input: {
      borderWidth: 1,
      borderColor: '#ddd',
      padding: 10,
      fontSize: 18,
      borderRadius: 6,
    },
    errorText: {
      color: 'crimson',
      fontWeight: 'bold',
      marginBottom: 10,
      marginTop: 6,
      textAlign: 'center',
    },
  });

export default globalStyles;
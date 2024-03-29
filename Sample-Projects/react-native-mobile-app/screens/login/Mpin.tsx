import React, { useRef, useState } from "react";
import { StyleSheet, Text, TextInput, View } from "react-native";
import GlobalStyles from "../../components/style/GlobalStyles";
import { StackNavigationProps } from "../../types/ComponentType";
import { GeneralUtils } from "../../util/GeneralUtils";

const Mpin = ({ navigation }: StackNavigationProps) => {
  const [pin, setPin] = useState<string[]>(["", "", "", ""]);
  const inputRefs = useRef([]);

  const handlePINChange = (value: string, index: number) => {
    const pinCopy = [...pin];
    pinCopy[index] = value;
    setPin(pinCopy);

    if (GeneralUtils.isNotEmpty(value)) {
      if (index < pin.length - 1) {
        inputRefs.current[index + 1].focus();
      } else {
        onSubmit();
      }
    } else {
      if (index > 0) {
        inputRefs.current[index - 1].focus();
      }
    }
  };

  const onSubmit = () => {
    navigation.navigate("Dashboard");
  };

  return (
    <>
      <View style={styles.body}>
        <View style={styles.container}>
          <Text style={styles.text}>Enter MPIN</Text>

          <View style={styles.textInput}>
            {pin.map((initVal, index) => (
              <TextInput
                key={index}
                ref={(ref) => (inputRefs.current[index] = ref)}
                style={styles.input}
                value={initVal}
                onChangeText={(input) => handlePINChange(input, index)}
                keyboardType="numeric"
                maxLength={1}
                secureTextEntry={true}
              />
            ))}
          </View>
        </View>
        <View style={GlobalStyles.footerContainer}>
          <Text style={[GlobalStyles.footer, styles.footer]}>Forgot MPIN?</Text>
        </View>
      </View>
    </>
  );
};

const styles = StyleSheet.create({
  body: {
    flex: 1,
    justifyContent: "center",
  },
  container: {
    flexDirection: "column",
    alignItems: "center",
  },
  textInput: {
    flexDirection: "row",
  },
  text: {
    fontSize: 20,
    color: "#ffffff",
    marginBottom: 30,
  },
  input: {
    width: 50,
    borderWidth: 1,
    borderColor: "#555",
    borderRadius: 10,
    backgroundColor: "#ffffff",
    height: 50,
    marginRight: 10,
    textAlign: "center",
  },
  footer: {
    marginTop: 40,
  },
});

export default Mpin;

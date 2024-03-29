import { ErrorMessage } from "formik";
import React from "react";
import { StyleSheet, TextInput, View } from "react-native";
import TextError from "./TextError";

function InputField(props: any) {
  return (
    <>
      <TextInput {...props} />
      <View style={styles.error}>
        <ErrorMessage name={props.name} component={TextError} />
      </View>
    </>
  );
}

const styles = StyleSheet.create({
  error: {
    marginTop: 10,
  },
});

export default InputField;

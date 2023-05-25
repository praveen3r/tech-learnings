import { ErrorMessage } from "formik";
import React from "react";
import { StyleSheet, TextInput, View } from "react-native";
import TextError from "./TextError";

function InputField(props: any) {
  return (
    <>
      <View>
        <TextInput {...props} />
        <ErrorMessage name={props.name} component={TextError} />
      </View>
    </>
  );
}

const styles = StyleSheet.create({
  input: {
    flex: 1,
  },
});

export default InputField;

import { ErrorMessage, Field } from "formik";
import React from "react";
import { StyleSheet, View } from "react-native";
import RNPickerSelect from "react-native-picker-select";
import TextError from "./TextError";

const DropdownComponent = (props: any) => {
  return (
    <>
      <View>
        <Field name={props.name}>
          {({ field }) => (
            <>
              <RNPickerSelect
                placeholder={{ label: "Select a value", value: "" }}
                style={{
                  ...styles,
                }}
                useNativeAndroidPickerStyle={false}
                onValueChange={field.onChange(field.name)}
                value={props.value}
                items={props.items}
              />
            </>
          )}
        </Field>
      </View>
      <View style={styles.error}>
        <ErrorMessage name={props.name} component={TextError} />
      </View>
    </>
  );
};

const styles = StyleSheet.create({
  inputAndroidContainer: {
    backgroundColor: "blue",
  },
  inputAndroid: {
    fontSize: 18,
    color: "white",
    backgroundColor: "blue",
  },
  placeholder: {
    color: "white",
    fontSize: 18,
    backgroundColor: "blue",
  },
  error: {
    marginTop: 10,
  },
});

export default DropdownComponent;

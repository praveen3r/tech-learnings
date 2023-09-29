import { FormikProvider, useFormik } from "formik";
import React from "react";
import { StyleSheet, Text, View } from "react-native";
import * as Yup from "yup";
import CustomButton from "../../components/button/CustomButton";
import InputComponent from "../../components/formik/InputComponent";
import { StackNavigationProps } from "../../types/ComponentType";
import { SoftwareType } from "../../types/FormType";
import { GeneralUtils } from "../../util/GeneralUtils";
import { MessageUtils } from "../../util/MessageUtils";

const validationSchema = Yup.object({
  name: Yup.string().required("Name cannot be empty"),
  type: Yup.string().required("Type cannot be empty"),
  isExecutable: Yup.string().required("Executable cannot be empty"),
});

const EditSoftware = ({ route }: StackNavigationProps) => {
  const initialValues = route.params as SoftwareType;

  const onSubmit = (values: SoftwareType) => {
    formik.validateForm(values).then(async (error) => {
      if (GeneralUtils.isNotEmptyObj(error)) {
        MessageUtils.showErrorObjMessage(error);
      } else {
      }
    });
  };

  const formik = useFormik({
    initialValues,
    validationSchema,
    validateOnChange: false,
    validateOnBlur: false,
    onSubmit,
  });

  return (
    <FormikProvider value={formik}>
      <View style={styles.container}>
        <View style={styles.input}>
          <Text style={styles.text}>Name</Text>
          <InputComponent
            dataType="text"
            placeholder="Enter name here"
            id="name"
            name="name"
            onChangeText={formik.handleChange("name")}
            value={formik.values.name}
          />
        </View>
        <View style={styles.input}>
          <Text style={styles.text}>Type</Text>
          <InputComponent
            dataType="text"
            placeholder="Enter type here"
            id="type"
            name="type"
            onChangeText={formik.handleChange("type")}
            value={formik.values.type}
          />
        </View>

        <View style={styles.input}>
          <Text style={styles.text}>Is Executable?</Text>
          <InputComponent
            dataType="text"
            placeholder="Enter is executable here"
            id="isExecutable"
            name="isExecutable"
            onChangeText={formik.handleChange("isExecutable")}
            value={formik.values.isExecutable}
          />
        </View>
      </View>
      <View style={styles.button}>
        <CustomButton
          title="Submit"
          onPressFunction={() => onSubmit(formik.values)}
        />
      </View>
    </FormikProvider>
  );
};

const styles = StyleSheet.create({
  container: {
    marginTop: 40,
  },
  button: {
    alignItems: "center",
  },

  input: {
    marginLeft: 20,
  },
  text: {
    marginBottom: 10,
    fontWeight: "bold",
    color: "#ffffff",
    fontSize: 18,
  },
});

export default EditSoftware;

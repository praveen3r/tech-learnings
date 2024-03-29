import { FormikProvider, useFormik } from "formik";
import React from "react";
import { StyleSheet, Text, View } from "react-native";
import * as Yup from "yup";
import CustomButton from "../../components/button/CustomButton";
import DropdownComponent from "../../components/formik/DropdownComponent";
import InputComponent from "../../components/formik/InputComponent";
import { StackNavigationProps } from "../../types/ComponentType";
import { CourseType } from "../../types/FormType";
import { GeneralUtils } from "../../util/GeneralUtils";
import { MessageUtils } from "../../util/MessageUtils";

const items: any = [
  { label: "Front end", value: "fntend" },
  { label: "Back end", value: "bkend" },
  { label: "Dev Ops", value: "devops" },
];

const validationSchema = Yup.object({
  name: Yup.string().required("Name cannot be empty"),
  type: Yup.string().required("Type cannot be empty"),
  author: Yup.string().required("Author cannot be empty"),
});

const EditCourse = ({ route }: StackNavigationProps) => {
  const initialValues = route.params as CourseType;

  const onSubmit = (values: CourseType) => {
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
          <DropdownComponent
            name="softwareType"
            items={items}
            value={formik.values.value}
          />
        </View>

        <View style={styles.input}>
          <Text style={styles.text}>Author</Text>
          <InputComponent
            dataType="text"
            placeholder="Enter author here"
            id="author"
            name="author"
            onChangeText={formik.handleChange("author")}
            value={formik.values.author}
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

export default EditCourse;

import { FormikProvider, useFormik } from "formik";
import React from "react";
import { StyleSheet, Text, View } from "react-native";
import * as Yup from "yup";
import CustomButton from "../../components/button/CustomButton";
import InputComponentWithIcon from "../../components/formik/InputComponentWithIcon";
import { ChangeKeywordType } from "../../types/FormType";
import { GeneralUtils } from "../../util/GeneralUtils";
import { MessageUtils } from "../../util/MessageUtils";

const initialValues: ChangeKeywordType = {
  oldKeyword: "",
  newKeyword: "",
  confirmNewKeyword: "",
};

const validationSchema = Yup.object({
  oldKeyword: Yup.string().required("Password cannot be empty"),
  newKeyword: Yup.string().required("Password cannot be empty"),
  confirmNewKeyword: Yup.string().required("Password cannot be empty"),
});

const ChangeKeyword = () => {
  const onSubmit = (values: ChangeKeywordType) => {
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
          <Text style={styles.text}>CURRENT PASSWORD</Text>
          <InputComponentWithIcon
            dataType="keyword"
            placeholder="Type password here"
            id="oldKeyword"
            name="oldKeyword"
            onChangeText={formik.handleChange("oldKeyword")}
            value={formik.values.oldKeyword}
          />
        </View>
        <View style={styles.input}>
          <Text style={styles.text}>NEW PASSWORD</Text>
          <InputComponentWithIcon
            dataType="keyword"
            placeholder="Type password here"
            id="confirmNewKeyword"
            name="confirmNewKeyword"
            onChangeText={formik.handleChange("keyword")}
            value={formik.values.confirmNewKeyword}
          />
        </View>

        <View style={styles.input}>
          <Text style={styles.text}>RE-ENTER NEW PASSWORD</Text>
          <InputComponentWithIcon
            dataType="keyword"
            placeholder="Type password here"
            id="confirmNewKeyword"
            name="confirmNewKeyword"
            onChangeText={formik.handleChange("keyword")}
            value={formik.values.confirmNewKeyword}
          />
        </View>
      </View>
      <View style={styles.footerNote}>
        <Text style={styles.note}>
          password must include atleast one number, one special character, one
          upper case, one lowercase and atleast 8 characters
        </Text>
        <CustomButton
          title="Update"
          onPressFunction={() => onSubmit(formik.values)}
          style={styles.button}
        />
      </View>
    </FormikProvider>
  );
};

const styles = StyleSheet.create({
  container: {
    marginTop: 40,
  },
  footerNote: {
    alignItems: "center",
  },

  input: {
    marginLeft: 20,
  },
  note: {
    fontSize: 12,
    color: "#ffffff",
    marginBottom: 10,
    marginTop: 30,
    marginLeft: 15,
  },
  text: {
    marginBottom: 10,
    fontWeight: "bold",
    color: "#ffffff",
  },
});

export default ChangeKeyword;

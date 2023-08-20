import { FormikProvider, useFormik } from "formik";
import React from "react";
import { StyleSheet, Text, View } from "react-native";
import * as Yup from "yup";
import CustomButton from "../../components/button/CustomButton";
import InputComponentWithBottomBorder from "../../components/formik/InputComponentWithBottomBorder";
import { MpinSetUpType } from "../../types/FormType";
import { GeneralUtils } from "../../util/GeneralUtils";
import { MessageUtils } from "../../util/MessageUtils";

const initialValues: MpinSetUpType = {
  oldMpin: "",
  newMpin: "",
  confirmNewMpin: "",
};

const validationSchema = Yup.object({
  oldMpin: Yup.string().required("mPin cannot be empty"),
  newMpin: Yup.string().required("mPin cannot be empty"),
  confirmNewMpin: Yup.string().required("mPin cannot be empty"),
});

const MpinSetup = () => {
  const onSubmit = (values: MpinSetUpType) => {
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
      <View>
        <Text style={styles.headerInfo}>
          An OTP will be sent to your email/mobile for confirmation
        </Text>

        <View style={styles.input}>
          <InputComponentWithBottomBorder
            dataType="text"
            placeholder="Enter old mPIN"
            id="oldMpin"
            name="oldMpin"
            onChangeText={formik.handleChange("oldMpin")}
            value={formik.values.oldMpin}
          />
        </View>
        <View style={styles.input}>
          <InputComponentWithBottomBorder
            dataType="text"
            placeholder="Enter new mPIN"
            id="newMpin"
            name="newMpin"
            onChangeText={formik.handleChange("newMpin")}
            value={formik.values.newMpin}
          />
        </View>

        <View style={styles.input}>
          <InputComponentWithBottomBorder
            dataType="text"
            placeholder="Confirm new mPIN"
            id="confirmNewMpin"
            name="confirmNewMpin"
            onChangeText={formik.handleChange("confirmNewMpin")}
            value={formik.values.confirmNewMpin}
          />
        </View>
      </View>
      <View style={styles.container}>
        <CustomButton
          title="Request OTP"
          onPressFunction={() => onSubmit(formik.values)}
          style={styles.button}
        />
      </View>
    </FormikProvider>
  );
};

const styles = StyleSheet.create({
  headerInfo: {
    marginLeft: 10,
    marginTop: 40,
    marginBottom: 40,
    color: "#ffffff",
  },
  container: {
    alignItems: "center",
  },
  button: {
    marginTop: 50,
  },
  input: {
    marginLeft: 20,
  },
});

export default MpinSetup;

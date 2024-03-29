import AsyncStorage from "@react-native-async-storage/async-storage";
import { FormikProvider, useFormik } from "formik";
import React from "react";
import { StyleSheet, Text, View } from "react-native";
import * as Yup from "yup";
import CustomButton from "../../components/button/CustomButton";
import InputComponentWithIcon from "../../components/formik/InputComponentWithIcon";
import GlobalStyles from "../../components/style/GlobalStyles";
import { StackNavigationProps } from "../../types/ComponentType";
import { LoginType } from "../../types/FormType";
import { GeneralUtils } from "../../util/GeneralUtils";
import { MessageUtils } from "../../util/MessageUtils";

const initialValues: LoginType = {
  userId: "",
  keyword: "",
};

const validationSchema = Yup.object({
  userId: Yup.string().required("Email or Phone is required"),
  keyword: Yup.string().required("Password is required"),
});

const LoginErrPopUp = ({ navigation }: StackNavigationProps) => {
  const onSubmit = (values: LoginType) => {
    formik.validateForm(values).then(async (error) => {
      if (GeneralUtils.isNotEmptyObj(error)) {
        MessageUtils.showErrorObjMessage(error);
      } else {
        try {
          const user = {
            name: values.userId,
          };
          await AsyncStorage.setItem("UserData", JSON.stringify(user));
          navigation.navigate("Mpin");
        } catch (error) {
          console.log(error);
        }
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
      <View style={styles.body}>
        <View style={styles.container}>
          <Text style={styles.text}>Login to your account</Text>
          <InputComponentWithIcon
            dataType="text"
            placeholder="EMAIL OR PHONE"
            id="userId"
            name="userId"
            onChangeText={formik.handleChange("userId")}
            value={formik.values.userId}
            iconType="user"
          />
          <InputComponentWithIcon
            dataType="keyword"
            placeholder="PASSWORD"
            id="keyword"
            name="keyword"
            onChangeText={formik.handleChange("keyword")}
            value={formik.values.keyword}
            isLeftIcon={true}
          />
        </View>
        <View style={GlobalStyles.footerContainer}>
          <Text style={[GlobalStyles.footer, styles.footer]}>
            Forgot password?
          </Text>
        </View>
        <View style={styles.container}>
          <CustomButton
            title="Login"
            onPressFunction={() => onSubmit(formik.values)}
            style={styles.button}
          />
        </View>
      </View>
    </FormikProvider>
  );
};

const styles = StyleSheet.create({
  body: {
    flex: 1,
  },
  container: {
    alignItems: "center",
  },
  logo: {
    width: 100,
    height: 100,
    margin: 20,
  },
  text: {
    fontSize: 20,
    color: "#ffffff",
    marginTop: 200,
    marginBottom: 30,
  },
  button: {
    marginTop: 40,
  },
  footer: {
    marginTop: 10,
  },
});

export default LoginErrPopUp;

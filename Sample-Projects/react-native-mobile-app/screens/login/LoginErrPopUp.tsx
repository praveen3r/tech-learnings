import { FontAwesome } from "@expo/vector-icons/";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { FormikProvider, useFormik } from "formik";
import React from "react";
import { StyleSheet, Text, View } from "react-native";
import * as Yup from "yup";
import CustomButton from "../../components/button/CustomButton";
import InputComponentWithIcon from "../../components/formik/InputComponentWithIcon";
import { StackNavigationProps } from "../../types/ComponentType";
import { LoginType } from "../../types/FormType";
import { MessageUtils } from "../../util/MessageUtils";

const initialValues: LoginType = {
  userId: "",
  keyword: "",
};

const validationSchema = Yup.object({
  userId: Yup.string().required("Email or Phone is required"),
  keyword: Yup.string().required("Password is required"),
});

export default function LoginErrPopUp({ navigation }: StackNavigationProps) {
  const onSubmit = (values: LoginType) => {
    formik.validateForm(values).then(async (error) => {
      if (error) {
        MessageUtils.showErrorObjMessage(error);
      } else {
        try {
          const user = {
            name: values.userId,
          };
          await AsyncStorage.setItem("UserData", JSON.stringify(user));
          navigation.navigate("Dashboard");
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
        {/* <Image
                  style={styles.logo}
                  source={require('../assets/asyncstorage.png')}
              /> */}

        <Text style={styles.text}>Login to your account</Text>
        <View style={styles.input}>
          <FontAwesome name={"user"} size={28} style={styles.icon} />

          <InputComponentWithIcon
            dataType="text"
            placeholder="EMAIL OR PHONE"
            id="userId"
            name="userId"
            onChangeText={formik.handleChange("userId")}
            value={formik.values.userId}
          />
        </View>
        <View style={styles.input}>
          <FontAwesome name={"lock"} size={28} style={styles.icon} />

          <InputComponentWithIcon
            dataType="keyword"
            placeholder="PASSWORD"
            id="keyword"
            name="keyword"
            onChangeText={formik.handleChange("keyword")}
            value={formik.values.keyword}
          />
        </View>
        <CustomButton
          title="Login"
          onPressFunction={() => onSubmit(formik.values)}
          style={styles.button}
        />
      </View>
    </FormikProvider>
  );
}

const styles = StyleSheet.create({
  body: {
    flex: 1,
    alignItems: "center",
    backgroundColor: "#0080ff",
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
  input: {
    flexDirection: "row",
    width: 300,
    borderWidth: 1,
    borderColor: "#555",
    borderRadius: 10,
    backgroundColor: "#ffffff",
    marginBottom: 25,
    height: 50,
  },
  icon: {
    paddingTop: 10,
    paddingLeft: 10,
  },
  button: {
    marginTop: 50,
  },
});

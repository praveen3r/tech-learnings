import { FontAwesome } from "@expo/vector-icons/";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { ErrorMessage, Formik, FormikHelpers } from "formik";
import React from "react";
import { StyleSheet, Text, View } from "react-native";
import * as Yup from "yup";
import CustomButton from "../../components/button/CustomButton";
import InputComponentWithIcon from "../../components/formik/InputComponentWithIcon";
import TextError from "../../components/formik/TextError";
import { StackNavigationProps } from "../../types/ComponentType";
import { LoginType } from "../../types/FormType";

const initialValues: LoginType = {
  userId: "",
  keyword: "",
};

const validationSchema = Yup.object({
  userId: Yup.string().required("User Id is required"),
  keyword: Yup.string().required("Password is required"),
});

const Login = ({ navigation }: StackNavigationProps) => {
  const onSubmit = async (
    values: LoginType,
    submitProps: FormikHelpers<LoginType>
  ) => {
    try {
      const user = {
        name: values.userId,
      };
      await AsyncStorage.setItem("UserData", JSON.stringify(user));
      submitProps.resetForm();
      navigation.navigate("Mpin");
    } catch (error) {
      console.log(error);
      submitProps.resetForm();
    }
  };

  return (
    <>
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={onSubmit}
      >
        {({ handleChange, handleSubmit, values }) => (
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
                onChangeText={handleChange("userId")}
                value={values.userId}
              />
            </View>
            <ErrorMessage name="userId" component={TextError} />
            <View style={styles.input}>
              <FontAwesome name={"lock"} size={28} style={styles.icon} />

              <InputComponentWithIcon
                dataType="keyword"
                placeholder="PASSWORD"
                id="keyword"
                name="keyword"
                onChangeText={handleChange("keyword")}
                value={values.keyword}
              />
            </View>
            <ErrorMessage name="keyword" component={TextError} />
            <CustomButton
              title="Login"
              onPressFunction={handleSubmit}
              style={styles.button}
            />
          </View>
        )}
      </Formik>
    </>
  );
};

const styles = StyleSheet.create({
  body: {
    flex: 1,
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

export default Login;

import React from "react";
import { Button, StyleSheet, Text, TouchableOpacity, View } from "react-native";
import { Camera, CameraType } from "expo-camera";
import { useState } from "react";
import CustomButton from "../utils/CustomButton";

function CameraTest() {
  const [type, setType] = useState(CameraType.back);
  const [permission, requestPermission] = Camera.useCameraPermissions();

  function toggleCameraType() {
    setType((current) =>
      current === CameraType.back ? CameraType.front : CameraType.back
    );
  }

  return (
    <View style={styles.body}>
      <Camera style={styles.camera} type={type}>
        <View style={styles.buttonContainer}>
        <Text style={styles.text}>Flip Camera</Text>
          <TouchableOpacity style={styles.button} onPress={toggleCameraType}>
            <Text style={styles.text}>Flip Camera</Text>
          </TouchableOpacity>
          <CustomButton
                    title="Capture"
                    color='#1eb900'
                    
                />
        </View>
      </Camera>
    </View>
  );
}

const styles = StyleSheet.create({
  body: {
    flex: 1,
  },
  preview: {
    flex: 1,
    alignItems: "center",
    justifyContent: "flex-end",
  },
  camera: {
    flex: 1,
    width: "100%",
  },
  buttonContainer: {},
});

export default CameraTest;

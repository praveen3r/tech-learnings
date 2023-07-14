import { Modal, StyleSheet, Text, View } from "react-native";
import { CustomModalType } from "../../types/ComponentType";
import CustomButtonModal from "../button/CustomButtonModal";

const CustomModal = (props: CustomModalType) => {
  return (
    <Modal
      visible={props.visible}
      transparent
      onRequestClose={() => props.onRequestClose(false)}
      animationType="slide"
      hardwareAccelerated
    >
      <View style={styles.body}>
        <View style={styles.content}>
          <Text style={styles.text}>{props.data}</Text>
          <View style={styles.buttonContainer}>
            <CustomButtonModal
              onPressFunction={() => props.onRequestClose(true)}
              title="Ok"
            />
            <CustomButtonModal
              onPressFunction={() => props.onRequestClose(false)}
              title="Close"
            />
          </View>
        </View>
      </View>
    </Modal>
  );
};

const styles = StyleSheet.create({
  body: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "rgba(0, 0, 0, 0.5)",
  },
  content: {
    backgroundColor: "#fff",
    padding: 20,
    borderRadius: 5,
    elevation: 5,
  },
  text: {
    fontSize: 16,
    marginBottom: 20,
  },
  buttonContainer: {
    flexDirection: "row",
    justifyContent: "space-between",
    paddingHorizontal: 20,
  },
});

export default CustomModal;

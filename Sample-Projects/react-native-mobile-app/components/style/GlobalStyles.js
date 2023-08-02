import { StyleSheet } from "react-native";

export default StyleSheet.create({
  background: {
    backgroundColor: "blue",
  },
  footerContainer: {
    justifyContent: "center",
    alignItems: "flex-end",
  },
  footer: {
    marginRight: 40,
    fontSize: 15,
    color: "#ffffff",
    textAlign: "right",
  },

  body: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  card: {
    flexDirection: "row",
    marginTop: 40,
    marginLeft: 10,
    borderWidth: 1,
    borderColor: "black",
    width: "95%",
  },
  cardHeader: {
    height: 80,
    alignItems: "center",
    justifyContent: "center",
  },
  cardChild: {
    height: 50,
    paddingLeft: 10,
    paddingTop: 10,
  },
  cardBody: {
    flex: 1,
    flexDirection: "row",
  },
  text: {
    marginLeft: 20,
    fontSize: 20,
    color: "#ffffff",
  },
  textColor: {
    color: "#ffffff",
  },
  arrow: {
    paddingRight: 20,
  },
  modalContainer: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
});

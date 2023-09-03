import { StackScreenProps } from "@react-navigation/stack";
import { ImageStyle, TextStyle, ViewStyle } from "react-native/types";

export type CustomButtonStyle = {
  container: ViewStyle;
  title: TextStyle;
  icon: ImageStyle;
};

// export type CustomButtonType<T> = {
//     style?: StyleSheet.NamedStyles<T>;
//     onPressFunction: () => void;
//     title: string;
// }

export type CustomButtonType = {
  style?: any;
  onPressFunction: () => void;
  title: string;
};

export type CustomModalType = {
  visible: boolean;
  onRequestClose: (isOkClicked: boolean) => void;
  data: string;
};

export type CustomCardType = {
  title: string;
  data: string;
};

export type CustomCardWithChildrenType = {
  title?: string;
  children?: JSX.Element;
};
export type StackNavigationProps = StackScreenProps<any>;

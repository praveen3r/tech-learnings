import React from "react";

export type ChildrenType = {
  children: React.ReactNode;
};

export type ErrorType = {
  children: JSX.Element;
};

export type RouteType = {
  path: string;
  component: React.ReactNode;
};

export type DefaultModalType = {
    showModal: boolean;
    hideModal: () => void;
    confirmModal: (id: string) => void;
    id: string;
}

export type FormModalType<T> = {
  showModal: boolean;
  hideModal: () => void;
  confirmModal: (data: T) => void;
  data: T;
}

export type DeleteConfirmationType = DefaultModalType & {
    message: string;
  };

  export type MessageModalType = {
    showModal: boolean;
    hideModal: () => void;
    message: string;
  };

  export type LanguageState = {
    locale:string;
  }

  export type LanguageAction = {
    type:string;
    lang:string;
  }

  export type LanguageContext = {
    state: LanguageState;
    dispatch: React.Dispatch<LanguageAction>;
  }


  export type AuthenticationContext = {
    isAuthenticated: boolean;
    login: (isAuthenticated: boolean, token: string) => void;
    logout: () => void;
  }

  export type IdleTimeOutType =  {
    showModal: boolean;
    handleContinue: () => void;
    handleLogout: () => void;
  };
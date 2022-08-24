import React, { createContext, useContext, useReducer} from 'react';
import { ChildrenType, LanguageAction, LanguageContext, LanguageState } from '../../types/ComponentType';

const LangContext = createContext<LanguageContext | null>(null);

export const LangProvider = ({ children }: ChildrenType) => {

    const initialState: LanguageState = {
        locale: "en"
    }

    const reducer = (state: LanguageState, action: LanguageAction) => {
        switch(action.type){
            case 'reset':
                return initialState;
            case 'setLocale': 
                return {locale: action.lang};
            default:
                return initialState;
        }
    }

    const [state, dispatch] = useReducer(reducer, initialState);

    return (
        <LangContext.Provider value={{ state, dispatch }}>
            {children}
        </LangContext.Provider>
    );

}

export const useLang = () => {
    return useContext(LangContext);
}
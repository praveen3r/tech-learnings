import { Fragment } from "react";
import { IntlProvider } from "react-intl";
import messages_de from "../messages/de-de.json";
import messages_en from "../messages/en-US.json";
import messages_fr from "../messages/fr-CA.json";
import { MessageType } from "../../types/MessageType";
import { LocaleProvideType } from "../../types/FormTypes";
import { useLang } from "../context/LangContent";

const messages: MessageType = {
    'de': messages_de,
    'en': messages_en,
    'fr': messages_fr
};

const Provider = ({children}: LocaleProvideType) => {

    const langContext = useLang();
    const state = langContext!.state;

    return(
    <IntlProvider textComponent={Fragment} locale={state.locale} messages={messages[state.locale]}
    defaultLocale="en"
    >
        {children}
        </IntlProvider>
        )
}

export default Provider
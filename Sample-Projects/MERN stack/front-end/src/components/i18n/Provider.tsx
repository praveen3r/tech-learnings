import { Fragment } from "react";
import { IntlProvider } from "react-intl";
import { LOCALES } from "./Constants";
import messages_de from "../messages/de-de.json";
import messages_en from "../messages/en-US.json";
import { MessageType } from "../../types/MessageType";
import { LocaleProvideType } from "../../types/FormTypes";

const messages: MessageType = {
    'de': messages_de,
    'en': messages_en
};

const Provider = ({children,locale= LOCALES.ENGLISH}: LocaleProvideType) => {
    return(
    <IntlProvider textComponent={Fragment} locale={locale} messages={messages[locale]}
    defaultLocale="en"
    >
        {children}
        </IntlProvider>
        )
}

export default Provider
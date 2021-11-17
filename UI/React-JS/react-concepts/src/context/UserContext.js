import React from 'react'

const UserContext = React.createContext();

const UserProducer = UserContext.Provider;
const UserConsumer = UserContext.Consumer;

export {UserProducer, UserConsumer}
export default UserContext;
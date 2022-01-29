import React from 'react';
import './App.css';
import { Provider } from 'react-redux';

import ReduxContainer from './components/ReduxContainer'
// import store from './cake/Store';
// import Demo from './hooks/use-selector/Demo';
// import rootStore from './redux/RootStore';
// import RootStoreWithMiddleWare from './redux/RootStoreWithMiddleWare'
import newCakeStore from './cake-with-action-payload/Store'
// import Demo from './hooks/use-dispatch/Demo';
// import RootContainer from './components/RootContainer'
import ContainerWithActionPayload from './components/ContainerWithActionPayload'


function App() {
  return (
    <div className="App">
      {/* <Provider store={store}> */}
      {/* <ReduxContainer></ReduxContainer> */}
      {/* <Demo></Demo> */}
      {/* </Provider> */}

      {/* <Provider store={rootStore}> 
         <RootContainer/>
         </Provider> */}

      {/* <Provider store={RootStoreWithMiddleWare}>
        <RootContainer />
      </Provider> */}

      <Provider store={newCakeStore}>
        <ContainerWithActionPayload />
      </Provider>
    </div>
  );
}

export default App;

import React from 'react';
import './App.css';
import { AdvancedProps1 } from './components/AdvancedProps1';
import AdvancedProps2 from './components/AdvancedProps2';
import AdvancedProps3 from './components/AdvancedProps3';
import { BasicProps } from './components/BasicProps';
import ClassComp from './components/ClassComp';
import ExternalProps from './components/ExternalProps';
import { ExtractPropsType } from './components/ExtractPropsType';
import GenericType from './components/GenericType';
import Greet from './components/Greet';
import { HtmlWrapperType } from './components/HtmlWrapperType';
import { PolymorphicComponent } from './components/PolymorphicComponent';
import { StyleProps } from './components/StyleProps';
import { TemplateLiterals } from './components/TemplateLiterals';
import UseReducerType from './components/UseReducerType';
import { UseRefType } from './components/UseRefType';
import { UseStateType } from './components/UseStateType';


function App() {
  return (
    <>
      {
      /* <Greet name="namaste"/>
      <BasicProps name={{first: 'Bruce', last: 'Wayne'}} 
      techList={[{type: 'UI', name: 'React'},{type: 'Java', name: 'Microservices'}]}/> 
      <AdvancedProps1 type='UI'/>
      <AdvancedProps2>Able to send children</AdvancedProps2>
      <AdvancedProps2> <AdvancedProps1 type='UI'/></AdvancedProps2>
      <StyleProps styles={{color: 'red'}}/>
      <ExternalProps name={{first: 'Bruce', last: 'Wayne'}}/>
      <UseStateType/>
      <UseReducerType/>
      <UseRefType/>
      <ClassComp message='This is from props'/>
      <>
         
          <GenericType items={['Praveen', 'Shree', 'Ranjani']} />
          <GenericType items={[1, 2, 3]} />
      </>
      <AdvancedProps3 value={101} isPositive />
      <TemplateLiterals position='bottom-center' />
      <HtmlWrapperType variant='primary' onClick={() => console.log("coming here")}>test children</HtmlWrapperType>
      <ExtractPropsType type='UI'/>*/
      <PolymorphicComponent as="h1">test polymorphism</PolymorphicComponent>
    }
    </>
  );
}

export default App;

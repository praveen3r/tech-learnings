import React from 'react'

// function FunctionalComponent(){
//     return <h1>Hello from function component</h1>
// }

//export const FunctionalComponent = () => <h1>Hello from function component</h1>

// const PropsFunctionalComp = (props) => {
//     return (
//         <div>
//             <h1>
//                 Hello Props func comp name {props.name} and id {props.id}
//             </h1>
//             {props.children}
//         </div>
//         )
// }

//Destructuring
const PropsFunctionalComp = (props) => {
    const {name, id} = props;
    return (
        <div>
            <h1>
                Hello Props func comp name {name} and id {id}
            </h1>
            {props.children}
        </div>
        )
}

export default PropsFunctionalComp;
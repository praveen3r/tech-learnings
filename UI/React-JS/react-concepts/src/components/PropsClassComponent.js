import React, { Component} from 'react'

// class PropsClassComponent extends Component{
//     render(){
//         return (
//         <div>
//         <h1>
//         Hello Props class comp name {this.props.name} and id {this.props.id}
//         </h1>
//         </div>
//         )
//     }
// }

//Destructuring
class PropsClassComponent extends Component{
    render(){
        const {name, id} = this.props;
        return (
        <div>
        <h1>
        Hello Props class comp name {name} and id {id}
        </h1>
        </div>
        )
    }
}

export default PropsClassComponent;
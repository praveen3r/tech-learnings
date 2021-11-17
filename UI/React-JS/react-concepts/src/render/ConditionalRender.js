import React, { Component } from 'react'

export class ConditionalRender extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             isLoggedIn: true
        }
    }
    
    render() {

       // return this.state.isLoggedIn ? (<div><p> Logged in </p></div>): (<div><p>not Logged in </p></div>);
        
        let display
        if(this.state.isLoggedIn){
            display = <p> Logged in </p>  ;
        }else{
            display = <p>not Logged in </p>  ;
        }
        return (
            <div>
                <p> {display} </p>    
            </div>
        )


        // if(this.state.isLoggedIn){
        //     return (
        //         <div>
        //             <p> Logged in </p>    
        //         </div>
        //     )
        // }else{
        //     return (
        //         <div>
        //             <p>Not Logged in </p>    
        //         </div>
        //     )
        // }
        
    }
}

export default ConditionalRender

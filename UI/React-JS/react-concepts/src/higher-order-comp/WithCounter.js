import React from 'react'

const withCounter = (WrappedComponent, incrementNumber) => {
    class WithCounter extends React.Component {

        constructor(props) {
            super(props)
        
            this.state = {
                 count : 0
            }
        }
    
        onClickHandler = () => {
            this.setState( prevState => {
               return {
                   count: prevState.count + incrementNumber
                } 
            })
        }

        render() {
            return <WrappedComponent count={this.state.count} 
                        onClickHandler={this.onClickHandler}
                        {... this.props}/>
        }
    }
    return WithCounter;
}

export default withCounter;
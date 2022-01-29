import React from 'react';
import cakeAction from '../cake/Action';
import { connect } from 'react-redux'

function ReduxContainer(props) {
    return <div>
        <div>
            Number of cakes - {props.numOfCakes}
        </div>
        <div>
            <button onClick={props.buyCake}>Buy Cake </button>
        </div>
    </div>;
}

const mapStateToProps = (state) => {
    return {
        numOfCakes: state.numOfCakes
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        buyCake: () => dispatch(cakeAction())
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(ReduxContainer);

import React, { useEffect } from 'react'

const Button = (props) => {
  const buttonArr = props.buttonArr;

    return (
      <>
    {buttonArr.map(value => <button onClick={() => value.setCount(prevCount => prevCount + 1)}>{value.count}</button>)}
    </>
  )
}

export default Button
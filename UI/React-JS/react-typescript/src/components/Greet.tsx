import React from 'react'

type greetingProps = {
    name: string
}

const Greet = (props: greetingProps) => {
  return (
    <div>Greeting with {props.name}</div>
  )
}

export default Greet
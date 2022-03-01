import React from 'react'
import {ExternalPropsType} from './common-types'

const ExternalProps = (props: ExternalPropsType) => {
  return (
    <div>The name is {props.name.first} {props.name.last}</div>
  )
}

export default ExternalProps
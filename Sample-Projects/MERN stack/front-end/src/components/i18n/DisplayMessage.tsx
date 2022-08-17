import React from 'react'
import { FormattedMessage } from 'react-intl'

const DisplayMessage = ({id}: any) => {
  return (
    <FormattedMessage id={id}/>
  )
}

export default DisplayMessage
import React from 'react'

type AdvancedProps2 = {
 //children: string
 children: React.ReactNode
}

const AdvancedProps2 = (props: AdvancedProps2) => {
  return (
    <div>{props.children}</div>
  )
}

export default AdvancedProps2
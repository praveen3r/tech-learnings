import React from 'react'

type AdvancedProps1 = {
 type: 'UI' | 'Java' | 'DB'
}

export const AdvancedProps1 = (props: AdvancedProps1) => {
  return (
    <div>I want to learn {props.type}</div>
  )
}

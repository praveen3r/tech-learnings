import React from 'react'

type StyleProps = {
    styles: React.CSSProperties
}

export const StyleProps = (props: StyleProps) => {
  return (
    <div style={props.styles}>StyleProps</div>
  )
}

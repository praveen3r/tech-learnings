import React from 'react'

type NewType = {
    as: React.ElementType,
    children: string
}
export const PolymorphicComponent = ({as, children}: NewType) => {
  const Component = as || "div";
  return (
    <Component>{children}</Component>
  )
}

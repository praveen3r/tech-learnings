import React from 'react'

type HtmlType = {
    variant: 'primary' | 'secondary',
    children: string
} & Omit<React.ComponentProps<'button'>,'children'>

export const HtmlWrapperType = ({variant, ...rest}: HtmlType) => {
  return (
    <button {...rest}>{variant}</button>
  )
}

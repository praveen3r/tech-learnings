import React from 'react'

/* works with react 17 only */
type verticalType = 'top' | 'center' | 'bottom';
type horizontalType = 'left' | 'center' | 'right';

type PositionalType = {
    position: Exclude<`${verticalType}-${horizontalType}`, "center-center"> 
              | "center"
};

export const TemplateLiterals = ({position}: PositionalType) => {
  return (
    <div>{position}</div>
  )
}

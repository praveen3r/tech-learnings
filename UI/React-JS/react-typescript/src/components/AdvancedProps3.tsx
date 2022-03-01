import React from 'react'

/* restrict to either positive or negative or zero */

type numberType = {
    value : number
}

type isPositiveType = numberType & {
    isPositive: boolean,
    isNegative?: never,
    isZero?: never,
}

type isNegativeType = numberType & {
    isPositive?: never,
    isNegative: boolean,
    isZero?: never,
}

type isZeroType = numberType & {
    isPositive?: never,
    isNegative?: never,
    isZero: boolean,
}

type advancedPropsType = isPositiveType | isNegativeType | isZeroType

const AdvancedProps3 = ({value, isPositive, isNegative, isZero}: advancedPropsType) => {
  return (
    <div>AdvancedProps3</div>
  )
}

export default AdvancedProps3
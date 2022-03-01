import React from 'react'

type ListType<T> = {
    items: T[]
}

//const GenericType = <T extends {}>({items} : ListType<T>) => {
const GenericType = <T extends string | number>({items} : ListType<T>) => {
  return (
    <>{items.map((value, index) => <div key={index}>{value}</div>)}</>
  )
}

export default GenericType
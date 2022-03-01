import React from 'react'

type basicProps = {
    name: {
        first: string,
        last: string
    },
    techList: {
        type: string,
        name: string
    }[]
}

export const BasicProps = (props: basicProps) => {
    return (
        <>
        <div>BasicProps with object {props.name.first} {props.name.last}</div>
        {props.techList.map(value => <div>tech to master under {value.type} are {value.name}</div>)}
        </>
    )
}

import React from 'react'

function ListRenderChild({person}) {
    return (
        <div>
            <h2>My name is {person.name} and my age is {person.age}</h2>
        </div>
    )
}

export default ListRenderChild

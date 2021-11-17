import React from 'react'
import ListRenderChild from './ListRenderChild'

function ListRenderParent() {

    const personList = 
    [{
        name: 'Person1',
        age:21
    },
    {
        name: 'Person2',
        age:22
    }
];
    const newPersonList = personList.map(person => <ListRenderChild key={person.age} person={person}></ListRenderChild>);
    return (
        <div>
            {newPersonList}
        </div>
    )
}

export default ListRenderParent

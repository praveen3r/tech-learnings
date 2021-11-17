import React from 'react'

function ListRender() {

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
    const newPersonList = personList.map(person => <h2>My name is {person.name} and my age is {person.age}</h2>);
    return (
        <div>
            {newPersonList}
        </div>
    )
}

export default ListRender

import React, {useState} from 'react'

function UseStateHookFour() {

    const [items, setItems] = useState([]);

    const onClickHandler = () => {
        setItems([...items, {
            id: items.length,
            value: Math.floor(Math.random() * 10) + 1
        }])
    }

    return (
        <div>
            <button onClick={onClickHandler}>Add value</button>
            {
                items.map(item => (<div key={item.id}>{item.value}</div>))
            }
        </div>
    )
}

export default UseStateHookFour

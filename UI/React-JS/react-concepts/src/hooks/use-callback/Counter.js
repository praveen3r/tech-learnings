import React from 'react'

function Counter({text, count}) {
    console.log('rendering counter')
    return (
        <div>
            {text} is {count}
        </div>
    )
}

export default React.memo(Counter)

import React from 'react'

function MemoComponent({name}) {
    console.log("Memo Component");
    return (
        
        <div>
            Memo Component {name}
        </div>
    )
}

export default React.memo(MemoComponent)

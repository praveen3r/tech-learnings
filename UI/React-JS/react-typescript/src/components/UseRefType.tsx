import React, { useEffect, useRef } from 'react'

export const UseRefType = () => {
  const inputRef = useRef<HTMLInputElement>(null!);

    useEffect(() => {
        inputRef.current.focus();
    }, []) 

    return (
        <div>
            <input ref={inputRef} type="text"/>
        </div>
    )
}

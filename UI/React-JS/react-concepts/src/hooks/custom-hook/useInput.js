import {useState} from 'react'

function useInput(initValue) {

    const [value, setValue] = useState(initValue);

    const reset = () => {
        setValue(initValue)
    }

    const bind = {
        value: value,
        onChange: e => {
            setValue(e.target.value)
        }
    }

    return [value, bind, reset]
}

export default useInput

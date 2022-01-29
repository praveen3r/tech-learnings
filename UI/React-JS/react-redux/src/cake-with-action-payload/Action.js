import { BUY_CAKE } from "./Constants"

const newCakeAction = (number) => {
    return {
        type: BUY_CAKE,
        payload: number
    }
}

export default newCakeAction
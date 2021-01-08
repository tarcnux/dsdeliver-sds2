import { useState } from "react"

function Counter() {

    const [counter, setCounter] = useState(0);

    const handleIncrease = () => {
        console.log('Incrementar')
        setCounter(counter + 1)
    }

    const handleDecrease = () => {
        console.log('Decrementar')
        setCounter(counter - 1)
    }

    return (
        <div>
            <button onClick={handleIncrease}>Incrementar</button>
            <button onClick={handleDecrease}>Decrementar</button>
            <h3>Valor do contador: {counter}</h3>
        </div>
    )
}

export default Counter;
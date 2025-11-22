import React, {useState} from 'react';

const users=[{name:"Juan", age:23},{name:"Elisa",age:40}]

export default ()=>{
    
    const totalAge = useMemo(()=>{
        let total = 0
        console.log("Calculando sumatorias de edad ...")
        users.forEach(x => {
            total = total+age
        })
        return total
    },[users])

    return(
        <Text>totalAge</Text>
    )
}
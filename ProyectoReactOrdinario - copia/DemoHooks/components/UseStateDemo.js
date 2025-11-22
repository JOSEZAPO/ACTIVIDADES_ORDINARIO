import React, {useEffect, useState} from 'react';
import {Text, StyleSheet} from 'react-native';

export default ()=>{
    // Definimos los estados para la carga y para guardar los usuarios
    const [loading, setLoading] = useState(true);
    const [usuarios, setUsuarios] = useState([]);


    //useEffect(()=>{
        // Simula un tiempo de carga
        //setTimeout(()=>{
            //setLoading(false);
        //}, 2000);
        //console.log("Ejecutando Effect");
        // No es necesario llamar a setLoading(true) aquí, el estado inicial ya es true.
    //}, []);

    const handleCarga = async()=>{
        const result = await fetch('https://jsonplaceholder.typicode.com/users')
        const json = await result.json()
        setUsuarios(json)
        setCarga(false)
    }

    useEffect(()=>{
        handleCarga();
    }, []);

    return (
        <>
            {/* Mostramos un mensaje de carga o los datos ya obtenidos */}
            <Text style={styles.texto}>
                {loading ? 'Cargando...' : (usuarios.length > 0 ? usuarios[0].name : 'No hay datos')}    
            </Text>    
        </>
    )
}

const styles = StyleSheet.create({
    texto: {
        fontSize: 48,
    }
})
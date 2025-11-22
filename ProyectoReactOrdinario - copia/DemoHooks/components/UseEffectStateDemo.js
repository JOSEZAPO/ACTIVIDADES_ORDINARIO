import React, {useState, useEffect}from 'react';
import {Text, StyleSheet, View} from 'react-native';

export default ()=>{
    // Es buena práctica nombrar la función seteadora acorde a la variable (p. ej. loading -> setLoading)
    const [loading, setLoading] = useState(true);
    const [usuarios, setUsuarios] = useState([]);
    
    useEffect(() => {
        // La función de useEffect no debe ser async directamente.
        // En su lugar, define una función async dentro y llámala.
        const fetchUsuarios = async () => {
            try {
                const result = await fetch('https://jsonplaceholder.typicode.com/users');
                const json = await result.json();
                setUsuarios(json);
            } catch (error) {
                console.error("Error al obtener los usuarios:", error);
            } finally {
                setLoading(false); // Se ejecuta tanto si hay éxito como si hay error.
            }
        };

        fetchUsuarios();
    }, []); // El array vacío asegura que el efecto se ejecute solo una vez.
    
    return (
        <View>
            {/* Usamos la variable correcta 'loading' y verificamos que 'usuarios' tenga datos */}
            <Text>{loading ? "Cargando datos..." : (usuarios.length > 0 ? usuarios[0].name : "No se encontraron usuarios")}</Text>
        </View>
    )
}
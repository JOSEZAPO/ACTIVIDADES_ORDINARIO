import React, { useContext } from 'react';
import { View, Button, Text, StyleSheet } from 'react-native';
import { AuthContext } from './AuthContext';

const HomeScreen = ({ navigation }) => {
  const { logout, userToken } = useContext(AuthContext);

  return (
    <View style={styles.container}>
      <Text style={styles.welcomeText}>¡Sesión Iniciada!</Text>
      <Text style={styles.tokenText}>Tu token es: {userToken}</Text>
      <View style={styles.menu}>
        <Button title="Ir a la Calculadora" onPress={() => navigation.navigate('Calculator')} />
        <Button title="Ir a Imprimir Nombre" onPress={() => navigation.navigate('Name')} />
        <Button title="Ir a Número Aleatorio" onPress={() => navigation.navigate('RandomNumber')} />
      </View>
      <Button title="Cerrar Sesión" color="red" onPress={logout} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: { flex: 1, alignItems: 'center', justifyContent: 'space-around', padding: 20 },
  welcomeText: { fontSize: 22, fontWeight: 'bold' },
  tokenText: { fontSize: 12, color: 'grey', fontStyle: 'italic', marginBottom: 20, textAlign: 'center' },
  menu: { width: '80%', gap: 15, marginBottom: 40 },
});

export default HomeScreen;
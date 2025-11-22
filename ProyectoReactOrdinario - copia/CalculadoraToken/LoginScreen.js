import React, { useContext } from 'react';
import { View, Button, Text, StyleSheet } from 'react-native';
import { AuthContext } from './AuthContext';

const LoginScreen = () => {
  const { login } = useContext(AuthContext);

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Bienvenido</Text>
      <Text style={styles.subtitle}>Por favor, inicia sesión para continuar</Text>
      <Button title="Iniciar Sesión (Simulado)" onPress={() => login('mi-token-secreto-123')} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: { flex: 1, justifyContent: 'center', alignItems: 'center', padding: 20, backgroundColor: '#f5f5f5' },
  title: { fontSize: 24, fontWeight: 'bold', marginBottom: 10 },
  subtitle: { fontSize: 16, color: 'gray', marginBottom: 20 },
});

export default LoginScreen;
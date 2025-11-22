import React, { useContext } from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { View, ActivityIndicator } from 'react-native'; // Importar componentes para la pantalla de carga
import { AuthContext } from './AuthContext';

import LoginScreen from './LoginScreen';
import HomeScreen from './HomeScreen';
import CalculatorScreen from './CalculatorScreen';
import NameScreen from './NameScreen';
import RandomNumberScreen from './RandomNumberScreen';

const Stack = createNativeStackNavigator();

const AppNavigator = () => {
  const { userToken, isLoading } = useContext(AuthContext);

  // Mientras se verifica el token, muestra una pantalla de carga
  if (isLoading) {
    return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
        <ActivityIndicator size="large" />
      </View>
    );
  }

  return (
    <Stack.Navigator>
      {/* La lógica de navegación ahora es correcta y no parpadeará */}
      {userToken == null ? (
        // No hay token, muestra la pantalla de login
        <Stack.Screen name="Login" component={LoginScreen} options={{ headerShown: false }} />
      ) : (
        // Hay token, muestra las pantallas de la app
        <>
          <Stack.Screen name="Home" component={HomeScreen} options={{ title: 'Inicio' }} />
          <Stack.Screen name="Calculator" component={CalculatorScreen} options={{ title: 'Calculadora' }} />
          <Stack.Screen name="Name" component={NameScreen} options={{ title: 'Imprime tu Nombre' }} />
          <Stack.Screen name="RandomNumber" component={RandomNumberScreen} options={{ title: 'Número Aleatorio' }} />
        </>
      )}
    </Stack.Navigator>
  );
};

export default AppNavigator;
import React from 'react';
import { AuthProvider } from './AuthContext';
import AppNavigator from './AppNavigator';
import { NavigationContainer } from '@react-navigation/native';

export default function App() {
  return (
    <AuthProvider>
      <NavigationContainer>
        <AppNavigator />
      </NavigationContainer>
    </AuthProvider>
  );
}

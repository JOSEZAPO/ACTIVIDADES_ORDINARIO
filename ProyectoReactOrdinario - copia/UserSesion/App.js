import { StyleSheet, Text, View, Button } from 'react-native';
import { AuthProvider, AuthContext } from './AuthContext';
import React, {useContext} from 'react';


function MainScreen(){
  const {userToken, login, logout} = useContext(AuthContext);

  return (
    <View style={styles.container}>
      <Text onPress = {()=>login("token123")}>Logueado: {userToken}</Text>
      <Button title="Deslogueate" onPress={()=>logout()}/>
    </View>
  )
}

export default function App() {
  return (
    <AuthProvider>
      <MainScreen/>
    </AuthProvider>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f0f0f0',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

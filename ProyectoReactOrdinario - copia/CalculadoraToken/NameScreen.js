import React, { useState } from 'react';
import { View, Text, TextInput, StyleSheet } from 'react-native';

const NameScreen = () => {
  const [name, setName] = useState('');

  return (
    <View style={styles.container}>
      <Text style={styles.label}>Escribe tu nombre:</Text>
      <TextInput
        style={styles.input}
        placeholder="Tu nombre aquí..."
        value={name}
        onChangeText={setName}
      />
      {name ? <Text style={styles.result}>Hola, {name}!</Text> : null}
    </View>
  );
};

const styles = StyleSheet.create({
  container: { flex: 1, alignItems: 'center', paddingTop: 40, paddingHorizontal: 20 },
  label: { fontSize: 18, marginBottom: 10 },
  input: { width: '100%', height: 40, borderColor: 'gray', borderWidth: 1, paddingHorizontal: 10, marginBottom: 20, borderRadius: 5 },
  result: { fontSize: 22, fontWeight: 'bold', color: 'blue' },
});

export default NameScreen;
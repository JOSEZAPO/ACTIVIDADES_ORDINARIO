import React, { useState } from 'react';
import { View, Text, Button, StyleSheet } from 'react-native';

const RandomNumberScreen = () => {
  const [number, setNumber] = useState(null);

  const generateRandom = () => {
    const randomNumber = Math.floor(Math.random() * 1000) + 1;
    setNumber(randomNumber);
  };

  return (
    <View style={styles.container}>
      <Button title="Generar Número Aleatorio (1-1000)" onPress={generateRandom} />
      {number !== null && (
        <Text style={styles.number}>
          {number}
        </Text>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: { flex: 1, justifyContent: 'center', alignItems: 'center', gap: 30 },
  number: { fontSize: 48, fontWeight: 'bold', color: 'green' },
});

export default RandomNumberScreen;
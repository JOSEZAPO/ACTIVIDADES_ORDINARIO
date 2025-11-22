import React, { useState } from 'react';
import { View, Text, Button, StyleSheet } from 'react-native';

const CalculatorScreen = () => {
  const [display, setDisplay] = useState('');

  const handlePress = (value) => {
    if (value === '=') {
      try {
        // OJO: eval() es inseguro para producción, pero útil para demos.
        const result = eval(display);
        setDisplay(String(result));
      } catch (e) {
        setDisplay('Error');
      }
    } else if (value === 'C') {
      setDisplay('');
    } else {
      setDisplay(display + value);
    }
  };

  const buttons = [
    ['7', '8', '9', '/'],
    ['4', '5', '6', '*'],
    ['1', '2', '3', '-'],
    ['0', '.', '=', '+'],
    ['C']
  ];

  return (
    <View style={styles.container}>
      <Text style={styles.display}>{display || '0'}</Text>
      <View style={styles.buttonsContainer}>
        {buttons.map((row, rowIndex) => (
          <View key={rowIndex} style={styles.row}>
            {row.map((button) => (
              <View key={button} style={styles.buttonWrapper}>
                <Button
                  title={button}
                  onPress={() => handlePress(button)}
                  color={button === 'C' ? 'red' : (isNaN(button) && button !== '.') ? '#f09a36' : '#333'}
                />
              </View>
            ))}
          </View>
        ))}
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: { flex: 1, justifyContent: 'flex-end', backgroundColor: '#f2f2f2' },
  display: {
    fontSize: 48,
    textAlign: 'right',
    padding: 20,
    backgroundColor: '#e0e0e0',
  },
  buttonsContainer: { padding: 10 },
  row: { flexDirection: 'row', justifyContent: 'space-around', marginBottom: 10 },
  buttonWrapper: {
    flex: 1,
    margin: 5,
  },
});

export default CalculatorScreen;
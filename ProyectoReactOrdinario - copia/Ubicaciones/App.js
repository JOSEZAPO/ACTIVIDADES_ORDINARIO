import { StatusBar } from 'expo-status-bar';
import { StyleSheet, View } from 'react-native';
import { Map, Modal, Panel } from './components';

export default function App() {
  const handleLongPress = ({nativeEvent}) => {
    console.log(nativeEvent);
  }
  return (
    <View style={styles.container}>
      <Map 
        longPress={handleLongPress}
      />
      <Modal />
      <Panel />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

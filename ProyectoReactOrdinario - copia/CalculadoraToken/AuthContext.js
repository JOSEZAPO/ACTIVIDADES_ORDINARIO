import React,{createContext, useState, useEffect} from "react";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { View, Text } from 'react-native';


export const AuthContext = createContext();

export const AuthProvider = ({children}) => {
    const [userToken, setUserToken] = useState(null);
    const [isLoading, setIsLoading] = useState(true); // Added loading state

    const login = async (token) =>{ // Added 'token' parameter here
        try {
            setUserToken(token);
            await AsyncStorage.setItem("usertoken", token);
        } catch (error) {
            console.error("Failed to save token:", error);
        }
    }

    const logout = async () =>{
        try {
            setUserToken(null);
            await AsyncStorage.removeItem("usertoken");
        } catch (error) {
            console.error("Failed to remove token:", error);
        }
    }

    const checkToken = async () =>{
        try {
            const token = await AsyncStorage.getItem("usertoken");
            if(token) setUserToken(token);
        } catch (error) {
            console.error("Failed to retrieve token:", error);
        } finally {
            setIsLoading(false); // Set loading to false after check
        }
    }

    useEffect(() => {
        checkToken();
    }, []);

    // Optionally, you can render a loading indicator here
    if (isLoading) {
        return (
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                <Text>Loading authentication...</Text>
            </View>
        );
    }

    return(
        <AuthContext.Provider value={{userToken, login, logout, isLoading}}>
            {children}
        </AuthContext.Provider>
    )
}
import React,{createContext, useState, useEffect} from "react";
import AsyncStorage from "@react-native-async-storage/async-storage";

export const AuthContext = createContext();

export const AuthProvider = ({children}) => {
    const [userToken, setUserToken] = useState(null);

    const login = async (token) =>{
        setUserToken(token);
        await AsyncStorage.setItem("usertoken", token);
    }

    const logout = async () =>{
        setUserToken(null);
        await AsyncStorage.removeItem("usertoken");
    }

    const checkToken = async () =>{
        const token = await AsyncStorage.getItem("usertoken");
        if(token) setUserToken(token);
    }

    useEffect(() => {
        checkToken();
    }, []);

    return(
        <AuthContext.Provider value={{userToken, login, logout}}>
            {children}
        </AuthContext.Provider>
    )
}
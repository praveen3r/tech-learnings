import React, { createContext, useContext, useState} from 'react';
import { AuthenticationContext, ChildrenType } from '../../types/ComponentType';

// const initialContext: AuthenticationContext = {
//     isAuthenticated: false,
//     login: function (isAuthenticated: boolean, token: string): void {
//         throw new Error('Function not implemented.');
//     },
//     logout: function (): void {
//         throw new Error('Function not implemented.');
//     }
// }
const AuthContext = createContext<AuthenticationContext | null>(null);

export const AuthProvider = ({ children }: ChildrenType) => {

    const [isAuthenticated, setAuthenticated] = useState(false);

    const login = (isAuthenticated: boolean, token: string) => {
        setAuthenticated(isAuthenticated);
        localStorage.setItem("token", token);
    }

    const logout = () => {
        setAuthenticated(false);
        localStorage.removeItem("token");
    }

    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
            {children}
        </AuthContext.Provider>
    );

}

export const useAuth = () => {
    return useContext(AuthContext);
}
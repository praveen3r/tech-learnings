import React from "react";
import { Navigate, useLocation } from "react-router-dom";
import { ChildrenType } from "../../types/ComponentType";
import { useAuth } from "../../components/context/Auth";

export function GuardedRoute({ children }: ChildrenType): JSX.Element {
  const auth = useAuth();
  const location = useLocation();
  
  if (!auth?.isAuthenticated) {
    return <Navigate to="/login" state={{ path: location.pathname }} />;
  }
  return <>{children}</>;
}

export default GuardedRoute;

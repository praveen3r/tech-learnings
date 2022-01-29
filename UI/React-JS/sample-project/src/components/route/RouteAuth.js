import React from 'react';
import { useAuth } from '../../util/Auth';

function RouteAuth({isAuthRequired, children}) {
  let authRequired = true;
  if(isAuthRequired == "false"){
    authRequired = false;
  }
  const auth = useAuth();

  if(authRequired && !auth.user){
      return  <p>Invalid session, please login</p>
  }
return <>{children}</>;
}

export default RouteAuth;

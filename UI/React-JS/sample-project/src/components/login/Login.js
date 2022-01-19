import React from 'react'

function Login() {
    return (
        <>
            
    <form >
    <div class="form-group">
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
          <label for="userid" >User Id</label>
        </div>
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <input type="text" 
              id="userId" name="userId" required
              class="form-control" 
              maxlength="15" autocomplete="off"
              placeholder="Enter userid" />
          </div>
        </div>
      
        <div class="form-group">
            <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
              <label for="pwd" >Pwd</label>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                <input type="password" 
                  id="pwd" name="pwd" required
                  class="form-control" 
                  maxlength="15" autocomplete="off"
                  placeholder="Enter pwd" />
              </div>
            </div>
      
      <div class="form-group" align="left">
        <button type="submit" class="btn btn-primary" >Submit</button>
        <button type="button" class="btn btn-default " > Clear</button >
      </div >
    
    </form >
        </>
    )
}

export default Login

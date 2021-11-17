try{
    adddlert("Welcome guest!");
}catch(error){
    console.log(error)
}finally {
    console.log("Block of code to be executed regardless of the try / catch result");
  }
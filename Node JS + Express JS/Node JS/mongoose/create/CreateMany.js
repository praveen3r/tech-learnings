const mongoose = require("mongoose");

main().catch((err) => console.log(err));

async function main() {
  await mongoose.connect("mongodb://localhost:27017/test");
}

const testSchema = new mongoose.Schema({
    id: Number,
    name: String,
  });

  const Test = mongoose.model("test", testSchema);


  Test.insertMany([
    { id: 5, name: 'test5'},
    { id: 7, name: 'test7'},
    { id: 8, name: 'test8'}
]).then(function(){
    console.log("Data inserted")  // Success
}).catch(function(error){
    console.log(error)      // Failure
});
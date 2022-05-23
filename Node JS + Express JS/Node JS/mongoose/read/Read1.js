const mongoose = require("mongoose");

main().catch((err) => console.log(err));

async function main() {
  await mongoose.connect("mongodb://localhost:27017/test");
}

const testSchema = new mongoose.Schema({
  id: Number,
  name: String,
});

const test = mongoose.model("test", testSchema);

const result = (err, data) => {
  if (err) {
    console.log(`err`);
  }
  console.log(data);
  /*const dat = data;
  for(value in dat){
    console.log(`value is ${value}`);
  }*/
};

//Get all results with id field
//test.find({},'id', result);

//Get all results with id and name field
//test.find({},'id name', result);

//Get one results with id and name field
//test.find({"name": "test2"},'id name', result);

//Get one result
//test.findOne({"name": "test2"}, result);

//Get results where id is less than 14 
//test.find({"id": { $lte: 14}},'id name', result);

//Get results where id is less than 14 or name is test2
//test.find({$or : [{"name" : "test2"}, {"id": { $lte: 14}}]},'id name', result);

//sort with id descending and select only id field
//test.find({}).select('id').sort('-id').exec(result); 

                //or

test.find({}).select({id:1}).sort({id:-1}).exec(result);

//sort with id descending and select only id field
//test.find({}).limit(1);

//mongoose.disconnect();

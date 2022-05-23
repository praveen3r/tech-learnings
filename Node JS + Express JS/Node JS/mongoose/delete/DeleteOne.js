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

const callback = (err, result) => {
  console.log(result);
};


Test.deleteOne(
  { id: 1 }, //where condition
  callback
);

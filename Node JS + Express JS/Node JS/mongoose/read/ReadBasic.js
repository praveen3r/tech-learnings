const mongoose = require("mongoose");

main().catch((err) => console.log(err));

async function main() {
  await mongoose.connect("mongodb://localhost:27017/test");
}

const bookSchema = new mongoose.Schema({
  name: String,
});

const book = mongoose.model("Book", bookSchema);

const result = (err, data) => {
  if (err) {
    console.log(`err`);
  }
  console.log(data);
};

//Get all results
//book.find(result);

//book.findOne({"name": "test2"}, result);

//mongoose.disconnect();

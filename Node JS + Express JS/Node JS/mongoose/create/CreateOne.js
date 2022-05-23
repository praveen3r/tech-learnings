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

  const test1 = new Test({ id: 6, name: "Test5" });

  test1.save(function (err) {
  if (err) return handleError(err);
  // saved!
});
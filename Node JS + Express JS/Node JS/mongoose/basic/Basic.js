const mongoose = require('mongoose');

main().catch(err => console.log(err));

async function main() {
  await mongoose.connect('mongodb://localhost:27017/test');
}

const bookSchema = new mongoose.Schema({
    name: String
  });

  const book = mongoose.model('Book', bookSchema);

  book.find((err, result) => {
      if(err){
          console.log(`err`);
      }
      console.log(result);
  });

  //mongoose.disconnect();
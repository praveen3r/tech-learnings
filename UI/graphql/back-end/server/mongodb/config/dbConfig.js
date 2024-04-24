const mongoose = require('mongoose');

const connectDB = async () => {
    
        const conn = await mongoose.connect('mongodb://localhost:27017/graphql')
          .then(() => {
            console.log('Connected to MongoDB database');
          })
          .catch((err) => {
            console.error('Failed to connect to MongoDB:', err);
          });
        }

module.exports = connectDB;
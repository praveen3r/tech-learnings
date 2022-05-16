const express = require('express');
const dotenv = require('dotenv').config();
const userRouter = require('../routes/userRoutes');
const errorHandler = require('../middleware/errorMiddleware');
const colors = require('colors');
const connectDB = require('../config/dbConfig');
const mongoose = require('mongoose');
const helmet = require('helmet');
const morgan = require('morgan');
const cors = require('cors');
const busboy = require('busboy');


const port = process.env.PORT || 5005;


const app = express();
connectDB();

/*const db = mongoose.connection;
db.on("error", console.error.bind(console, "connection error: "));
db.once("open", function () {
  console.log("Connected successfully");
});*/

app.use(helmet());
app.use(cors());
app.use(morgan('dev'));
app.use(express.json());

app.use('/api/users', userRouter);

app.use(errorHandler);

app.listen(port, () => {
    console.log(`server started in port ${port}`)
});
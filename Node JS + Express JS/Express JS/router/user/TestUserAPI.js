const express = require('express');
const userRouter = require('/UserRoute')

const app = express();

app.use('/api/test',userRouter);

app.listen(5000, ()=> {
    console.log(`server started in port 5000`);
});
const asyncHandler = require("express-async-handler");
const user = require("../model/userModel");
const busboy = require('busboy');

//@desc get user info
//@route /api/users
const getUser = asyncHandler(async (req, res) => {
  try {
    const users = await user.find();
    res.status(200).json({ users: users });
  } catch (err) {
    console.log(`Error occured ${err}`);
  }
});

//@desc save user info
//@route /api/users
const saveUser = asyncHandler(async (req, res) => {
  if (!req.body.name) {
    res.status(400);
    throw new Error(`send proper data please`);
  }
  try {
    const userRes = await user.create({
      id: req.body.id,
      name: req.body.name,
    });
  } catch (err) {
    console.log(`Error occured ${err}`);
  }

  /*const userNew = new user({
        id: req.body.id,
        name: req.body.name
    });

     const savedUser = await userNew.save().then(data=> {
        res.status(200).json({success:true});
    }).catch(err => {
        throw new Error(err);
    });

    try{
    const savedUser = await userNew.save();
    res.status(200).json({success:true});
    }catch(err){
        console.log(`Error occured ${err}`);
    }*/
});

//@desc update user info
//@route /api/user/:id
const updateUser = asyncHandler(async (req, res) => {
  const userOld = await user.findById(req.params.id);
  if (!userOld) {
    res.status(400);
    throw new Error("User not found");
  }
  await user.findByIdAndUpdate(req.params.id, req.body, { new: false });
  res.status(200).json({ success: true });
});

//@desc delete user info
//@route /api/user/:id
const deleteUser = asyncHandler(async (req, res) => {
  const userOld = await user.findById(req.params.id);
  if (!userOld) {
    res.status(400);
    throw new Error("User not found");
  }

  await user.deleteOne({ _id: userOld._id });
  //await user.remove({ _id: userOld._id });
  res.status(200).json({ success: true });
});

const handleUpload = (req, res) => {
  console.log(`coming here`);
  try {
    const bb = busboy({
      headers: req.headers,
    });
    bb.on('file', (name, file, info) => {
        const { filename, encoding, mimeType } = info;
        console.log(
          `File [${name}]: filename: %j, encoding: %j, mimeType: %j`,
          filename,
          encoding,
          mimeType
        );
        file.on('data', (data) => {
          console.log(`File [${name}] got ${data.length} bytes`);
        }).on('close', () => {
          console.log(`File [${name}] done`);
        });
      });
      bb.on('field', (name, val, info) => {
        console.log(`Field [${name}]: value: %j`, val);
      });
      bb.on('close', () => {
        console.log('Done parsing form!');
       // res.writeHead(303, { Connection: 'close', Location: '/' });
        res.end();
      });
      req.pipe(bb);
  } catch (err) {
    console.log(err);
  }
};

module.exports = { getUser, saveUser, updateUser, deleteUser, handleUpload };

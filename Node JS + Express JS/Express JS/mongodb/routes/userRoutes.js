const express = require('express');
const {getUser, saveUser, updateUser, deleteUser, handleUpload} = require('../controller/userController')
const router = express.Router();

router.route("/").get(getUser).post(saveUser);

router.route("/:id").put(updateUser).delete(deleteUser);

router.post("/file", handleUpload);

module.exports = router;